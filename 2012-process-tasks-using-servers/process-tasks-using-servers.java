import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        PriorityQueue<Integer> free = new PriorityQueue<>(
            (a, b) -> {
                if (servers[a] != servers[b]) {
                    return servers[a] - servers[b];
                }
                return a - b;
            }
        );

        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[2], b[2]);
            }
        );

        for (int i = 0; i < n; i++) {
            free.add(i);
        }

        long time = 0;

        for (int i = 0; i < m; i++) {

            time = Math.max(time, i);

            // Free all servers whose task is finished
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] server = busy.poll();
                free.add(server[2]);
            }

            // If no server is free, jump to the earliest finish time
            if (free.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    int[] server = busy.poll();
                    free.add(server[2]);
                }
            }

            int serverIndex = free.poll();

            ans[i] = serverIndex;

            // [finishTime, weight, index]
            busy.add(new int[]{
                (int)(time + tasks[i]),
                servers[serverIndex],
                serverIndex
            });
        }

        return ans;
    }
}