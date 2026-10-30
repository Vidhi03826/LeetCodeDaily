class Solution {
   long dp[][][] ; 
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        dp = new long[n][k+1][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                for(int l=0;l<3;l++){
                    dp[i][j][l]=Long.MIN_VALUE;
                    
                }
            }
        }
      return solve(0 , k , 0 , prices);
    }

    public long solve(int i , int k , int CASE , int[] prices){

        if(i==prices.length){
            if(CASE==0){
                return 0;
            }
            return Long.MIN_VALUE/2;
        }

        if(dp[i][k][CASE]!= Long.MIN_VALUE){
            return dp[i][k][CASE];
        }
        long nottake = solve(i+1 , k , CASE , prices);
        long take =  Long.MIN_VALUE;
        if(k>0){
           
            if(CASE==1){
                //sell
                take = prices[i] + solve(i+1 , k-1 , 0 , prices);
            }

            else if(CASE==2){
                //buy hi krna hai
                take = -prices[i] + solve(i+1 , k-1 , 0 , prices);
            }

        else{
            take = Math.max(- prices[i] + solve(i+1 , k, 1 , prices), prices[i] + solve(i+1 , k , 2 , prices));
        }
        }
        return dp[i][k][CASE] = Math.max(take , nottake);
    }
}