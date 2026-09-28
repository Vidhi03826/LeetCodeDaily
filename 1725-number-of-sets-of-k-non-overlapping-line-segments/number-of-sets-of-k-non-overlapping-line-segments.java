import java.util.*;

class Solution {

    int M = 1_000_000_007;
    int[][] dp = new int[1001][1001];

    public int numberOfSets(int n, int K) {

        // Base case: k = 0
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int k = 1; k <= K; k++) {

            // Calculate suffix sums of previous row
            int[] prevRowSum = new int[n + 1];

            for (int i = n - 1; i >= 0; i--) {
                prevRowSum[i] =
                    (prevRowSum[i + 1] + dp[k - 1][i]) % M;
            }

            // Calculate current row
            for (int i = n - 1; i >= 0; i--) {

                // Take current point as starting point
                int take = prevRowSum[i + 1];

                // Skip current point
                int skip = 0;

                if (i + 1 < n) {
                    skip = dp[k][i + 1];
                }

                dp[k][i] = (take + skip) % M;
            }
        }

        return dp[K][0];
    }
}