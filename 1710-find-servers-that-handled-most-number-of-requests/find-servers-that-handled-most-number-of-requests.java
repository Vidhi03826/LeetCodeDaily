import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        TreeSet<Integer> free = new TreeSet<>();

        // {finishTime, serverIndex}
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] count = new int[k];

        for (int i = 0; i < k; i++) {
            free.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {

            int time = arrival[i];

            // Release servers that have finished
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] server = busy.poll();
                free.add(server[1]);
            }

            // No server available
            if (free.isEmpty()) {
                continue;
            }

            // Find server starting from i % k
            int server = i % k;

            Integer idx = free.ceiling(server);

            // Wrap around if no suitable server exists
            if (idx == null) {
                idx = free.first();
            }

            free.remove(idx);

            count[idx]++;

            busy.offer(new int[]{arrival[i] + load[i], idx});
        }

        // Find maximum requests handled
        int max = 0;

        for (int i = 0; i < k; i++) {
            max = Math.max(max, count[i]);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}