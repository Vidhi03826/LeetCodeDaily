class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        // suffix[i] = sum of piles from i to n-1
        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        int[][] dp = new int[n][n + 1];

        return solve(0, 1, piles, suffix, dp);
    }

    private int solve(int i, int M, int[] piles,
                      int[] suffix, int[][] dp) {

        if (i >= piles.length) {
            return 0;
        }

        // If we can take all remaining piles
        if (i + 2 * M >= piles.length) {
            return suffix[i];
        }

        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        int best = 0;

        // Take X piles, where 1 <= X <= 2M
        for (int X = 1; X <= 2 * M; X++) {

            int nextM = Math.max(M, X);

            // Current player gets:
            // remaining stones - opponent's best
            int current =
                suffix[i] - solve(i + X, nextM, piles, suffix, dp);

            best = Math.max(best, current);
        }

        return dp[i][M] = best;
    }
}