

class Solution {
    public int getans(int[] prices, int ind, int buy, int n,int k, int [][][] dp){
          if (ind == n || k == 0)
            return 0;

        if(dp[ind][buy][k]!=-1) return dp[ind][buy][k];
        int profit;

        if(buy==0){//can buy
          profit = Math.max((-prices[ind] + getans(prices, ind+1,1 ,n, k, dp)) , getans(prices, ind+1,0 ,n,k,dp));
        }
        else {//cant buy
            profit=  Math.max((prices[ind] + getans(prices, ind+1,0 ,n,k-1,dp)) , getans(prices, ind+1,1 ,n,k,dp));
        }
        dp[ind][buy][k] = profit;
        return profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        
        int [][][] dp = new int [n][2][k+1];
     for(int i=0;i<n;i++){
        for(int j=0;j<2;j++){
            Arrays.fill(dp[i][j] , -1);
        }
     }
      return getans(prices, 0,0 ,n,k,dp);

         
    }
}