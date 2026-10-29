class Solution {
    int [][] dp;
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        dp = new int[n][n];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                dp[i][j] = -1;
            }
        }

        return solve(0 , n-1 , values);
    }

    public int solve(int i , int j , int[] values){
        if(j-i+1<3){
            return 0;
        }

        int result = Integer.MAX_VALUE;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        for(int k = i+1 ; k<j; k++){
            int wt = values[i]* values[j] * values[k] + solve(i , k , values) + solve(k , j , values);

            result = Math.min(result , wt);
        }
        return dp[i][j] = result;
    }
}