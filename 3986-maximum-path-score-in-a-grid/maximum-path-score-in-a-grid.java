class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m + 1][n + 1][k + 1];

        // initialize with -1 (invalid state)
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int c = 0; c <= k; c++) {
                    dp[i][j][c] = -1;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int cost = k; cost >= 0; cost--) {

                   int newCost = cost + (grid[i][j] > 0 ? 1 : 0);

                    if (newCost > k) continue;

                    // base case
                    if (i == m - 1 && j == n - 1) {
                        dp[i][j][cost] = grid[i][j];
                        continue;
                    }

                    int down = -1, right = -1;

                    if (i + 1 < m)
                        down = dp[i + 1][j][newCost];

                    if (j + 1 < n)
                        right = dp[i][j + 1][newCost];

                    int bestNext = Math.max(down, right);

                    if (bestNext != -1) {
                        dp[i][j][cost] = grid[i][j] + bestNext;
                    }
                }
            }
        }

        return dp[0][0][0];
    }
}

