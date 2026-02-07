class Solution {
      public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // initialize dp with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(grid, dp, m - 1, n - 1);
    }
     public int helper(int[][] grid, int [][] dp , int i, int j ){
        if(i<0 || j<0) return Integer.MAX_VALUE;

       

        if(i==0 && j==0) {
            return grid[0][0];
        }
         if(dp[i][j]!=-1) return dp[i][j];
       
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        if (i > 0)
            up = helper(grid, dp, i - 1, j);

        if (j > 0)
            left = helper(grid, dp, i, j - 1);

        dp[i][j] = grid[i][j] + Math.min(up, left);
        return dp[i][j];

    
}
    }

   