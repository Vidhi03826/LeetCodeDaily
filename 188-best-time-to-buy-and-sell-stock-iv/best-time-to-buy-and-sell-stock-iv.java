class Solution {
    public int getans (int[] prices, int idx,int buy, int n, int k, int [][][] dp){
        if(idx==n || k==0) return 0;
         int profit ;

          if(dp[idx][buy][k] !=-1) return dp[idx][buy][k];

         if(buy==0){
            profit = Math.max((-prices[idx] +  getans (prices, idx+1, 1, n,k, dp)),
                                   0         +   getans (prices, idx+1, 0, n,k, dp));
         }
         else{
             profit = Math.max((prices[idx] +  getans (prices, idx+1, 0, n,k-1, dp)),
                                   0         +   getans (prices, idx+1, 1, n,k, dp));
         }
         dp[idx][buy][k] = profit;
         return profit;
        
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int [][][] dp = new int [n][2][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return getans (prices, 0, 0, n,k, dp);
    }
}