class Solution {

    public boolean solve(int i, int j, int opencount,
                         char[][] grid, int[][][] dp) {

        // '(' -> +1
        // ')' -> -1
        opencount += (grid[i][j] == '(') ? 1 : -1;

        int m = grid.length;
        int n = grid[0].length;

        // Invalid balance
        if (opencount < 0)
            return false;

        // Already calculated
        if (dp[i][j][opencount] != -1) {
            return dp[i][j][opencount] == 1;
        }

        // Destination
        if (i == m - 1 && j == n - 1) {
            dp[i][j][opencount] = (opencount == 0) ? 1 : 0;
            return opencount == 0;
        }

        // Down
        if (i + 1 < m) {
            if (solve(i + 1, j, opencount, grid, dp)) {
                dp[i][j][opencount] = 1;
                return true;
            }
        }

        // Right
        if (j + 1 < n) {
            if (solve(i, j + 1, opencount, grid, dp)) {
                dp[i][j][opencount] = 1;
                return true;
            }
        }

        // No valid path
        dp[i][j][opencount] = 0;
        return false;
    }

    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Total path length must be even
        if ((m + n - 1) % 2 == 1)
            return false;

        // Must start with '(' and end with ')'
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
            return false;

        int[][][] dp = new int[m][n][m + n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 0, 0, grid, dp);
    }
}