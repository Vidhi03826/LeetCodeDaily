class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 0, 0, grid, k, dp, m, n);
    }

    public int solve(int i, int j, int rem, int[][] grid, int k,
                     int[][][] dp, int m, int n) {

        if (i >= m || j >= n) {
            return 0;
        }

        rem = (rem + grid[i][j]) % k;

        if (i == m - 1 && j == n - 1) {
            return rem == 0 ? 1 : 0;
        }

        if (dp[i][j][rem] != -1) {
            return dp[i][j][rem];
        }

        int right = solve(i, j + 1, rem, grid, k, dp, m, n);
        int down = solve(i + 1, j, rem, grid, k, dp, m, n);

        return dp[i][j][rem] = (int) (((long) right + down) % 1_000_000_007);
    }
}