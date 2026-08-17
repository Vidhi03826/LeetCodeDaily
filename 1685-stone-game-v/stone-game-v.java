class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int prefix[] = new int[n + 1];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int l = 0; len + l - 1 < n; l++) {
                int r = len + l - 1;
                for (int i = l; i < r; i++) {

                    int leftsum = prefix[i + 1] - prefix[l];
                    int rightsum = prefix[r + 1] - prefix[i + 1];

                    if (leftsum < rightsum) {

                        dp[l][r] = Math.max(
                                dp[l][r],
                                leftsum + dp[l][i]);

                    } else if (leftsum > rightsum) {

                        dp[l][r] = Math.max(
                                dp[l][r],
                                rightsum + dp[i + 1][r]);

                    } else {
                        dp[l][r] = Math.max(dp[l][r], leftsum + Math.max(dp[l][i], dp[i + 1][r]));

                    }
                }

            }
        }
        return dp[0][n - 1];
    }
}