
import java.util.*;

class Solution {

    TreeMap<Integer, Integer> low = new TreeMap<>();
    TreeMap<Integer, Integer> high = new TreeMap<>();

    int lowSize = 0, highSize = 0;
    long lowSum = 0, highSum = 0;

    public void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    public void remove(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);

        if (count == 1) {
            map.remove(val);
        } else {
            map.put(val, count - 1);
        }
    }

    public void insert(int val) {
        if (low.isEmpty() || val <= low.lastKey()) {
            add(low, val);
            lowSize++;
            lowSum += val;
        } else {
            add(high, val);
            highSize++;
            highSum += val;
        }

        balance();
    }

    public void erase(int val) {
        if (low.containsKey(val)) {
            remove(low, val);
            lowSize--;
            lowSum -= val;
        } else {
            remove(high, val);
            highSize--;
            highSum -= val;
        }

        balance();
    }

    public void balance() {

        while (lowSize > highSize + 1) {
            int val = low.lastKey();

            remove(low, val);
            lowSize--;
            lowSum -= val;

            add(high, val);
            highSize++;
            highSum += val;
        }

        while (lowSize < highSize) {
            int val = high.firstKey();

            remove(high, val);
            highSize--;
            highSum -= val;

            add(low, val);
            lowSize++;
            lowSum += val;
        }
    }

    public long getCost() {
        long median = low.lastKey();

        return median * lowSize - lowSum
             + highSum - median * highSize;
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Cost of every window of size x
        long[] cost = new long[n - x + 1];

        for (int i = 0; i < n; i++) {

            insert(nums[i]);

            if (i >= x) {
                erase(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = getCost();
            }
        }

        // DP: minimum cost to select k non-overlapping windows
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= k; j++) {

                if (dp[i][j] == INF) continue;

                // Skip current index
                dp[i + 1][j] = Math.min(
                    dp[i + 1][j],
                    dp[i][j]
                );

                // Select window starting at i
                if (j < k && i + x <= n) {

                    dp[i + x][j + 1] = Math.min(
                        dp[i + x][j + 1],
                        dp[i][j] + cost[i]
                    );
                }
            }
        }

        return dp[n][k];
    }
}
