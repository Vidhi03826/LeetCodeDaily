import java.util.*;

class Solution {

    static class State {
        long weight;
        List<Integer> indices;

        State(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // start, end, weight, original index
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by ending time
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        State[][] dp = new State[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new State(0, new ArrayList<>());
            }
        }

        for (int i = 1; i <= n; i++) {

            for (int k = 1; k <= 4; k++) {

                // Don't take current interval
                State notTake = dp[i - 1][k];

                // Take current interval
                int prev = findPrevious(arr, i - 1);

                State previous = dp[prev + 1][k - 1];

                List<Integer> list =
                    new ArrayList<>(previous.indices);

                list.add(arr[i - 1][3]);

                Collections.sort(list);

                State take = new State(
                    previous.weight + arr[i - 1][2],
                    list
                );

                dp[i][k] = better(notTake, take);
            }
        }

        List<Integer> result = dp[n][4].indices;

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private State better(State a, State b) {

        if (a.weight > b.weight) {
            return a;
        }

        if (b.weight > a.weight) {
            return b;
        }

        // Same weight -> lexicographically smaller
        if (lexicographicallySmaller(a.indices, b.indices)) {
            return a;
        }

        return b;
    }

    private boolean lexicographicallySmaller(
        List<Integer> a,
        List<Integer> b
    ) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }

    private int findPrevious(int[][] arr, int idx) {

        int low = 0;
        int high = idx - 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid][1] < arr[idx][0]) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}