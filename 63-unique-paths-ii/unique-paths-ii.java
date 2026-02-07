class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
               int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
           if (obstacleGrid[0][0] == 1) return 0; // start obstacle
         int [][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
       return helper(dp,obstacleGrid ,m-1, n-1);
    }
     public int helper(int [][] dp,int[][] obstacleGrid, int i, int j){
       
        if(i==0 && j==0) {
            return 1;
        }
        if(i<0 || j<0){
             return 0;
        }
        if(i>=0 && j>=0 && obstacleGrid[i][j]==1) return 0;
         if(dp[i][j]!=-1) return dp[i][j];
        int upways = helper(dp,obstacleGrid, i-1, j);
        int downways = helper(dp, obstacleGrid, i, j-1);

        return dp[i][j] = upways + downways;
    }
}