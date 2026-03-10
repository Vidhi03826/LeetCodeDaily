class Solution {
    // public int solve(List<List<Integer>> triangle, int n, int i, int j, int[][] dp) {

    //     // Base case: last row
    //     if (i == n - 1) {
    //         return dp[i][j] = triangle.get(i).get(j);
    //     }

    //     // Memoization check
    //     if (dp[i][j] != -1)
    //         return dp[i][j];

    //     int down = triangle.get(i).get(j) + solve(triangle, n, i + 1, j, dp);
    //     int diag = triangle.get(i).get(j) + solve(triangle, n, i + 1, j + 1, dp);

    //     return dp[i][j] = Math.min(down, diag);
    // }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for(int j=0;j<n;j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int up = triangle.get(i).get(j) + dp[i+1][j];
                int diag = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(up, diag);
            }
        }
        return dp[0][0];

    }
}

