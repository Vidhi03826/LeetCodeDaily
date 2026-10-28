
class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MAX = 1024;

        boolean[][][] dp = new boolean[m][n][MAX];

        dp[0][0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                int val = grid[i][j];

                for (int xor = 0; xor < MAX; xor++) {

                    if (i > 0 && dp[i - 1][j][xor]) {
                        dp[i][j][xor ^ val] = true;
                    }

                    if (j > 0 && dp[i][j - 1][xor]) {
                        dp[i][j][xor ^ val] = true;
                    }
                }
            }
        }

        for (int xor = 0; xor < MAX; xor++) {
            if (dp[m - 1][n - 1][xor]) {
                return xor;
            }
        }

        return -1;
    }
}
