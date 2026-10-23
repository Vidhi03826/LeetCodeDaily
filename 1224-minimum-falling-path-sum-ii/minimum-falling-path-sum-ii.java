
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        // Base case: last row
        for (int col = 0; col < m; col++) {
            dp[n - 1][col] = grid[n - 1][col];
        }

        // Fill from bottom to top
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < m; col++) {

                int ans = Integer.MAX_VALUE;

                for (int nextCol = 0; nextCol < m; nextCol++) {
                    if (nextCol != col) {
                        ans = Math.min(
                            ans,
                            grid[row][col] + dp[row + 1][nextCol]
                        );
                    }
                }

                dp[row][col] = ans;
            }
        }

        // Minimum answer from the first row
        int ans = Integer.MAX_VALUE;

        for (int col = 0; col < m; col++) {
            ans = Math.min(ans, dp[0][col]);
        }

        return ans;
    }
}
