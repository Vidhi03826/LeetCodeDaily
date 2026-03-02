class Solution {
    public int getans(int[] prices, int ind, int buy, int n,int [][] dp){
        if(ind==n) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit;

        if(buy==0){//can buy
          profit = Math.max((-prices[ind] + getans(prices, ind+1,1 ,n,dp)) , getans(prices, ind+1,0 ,n,dp));
        }
        else {//cant buy
            profit=  Math.max((prices[ind] + getans(prices, ind+1,0 ,n,dp)) , getans(prices, ind+1,1 ,n,dp));
        }
        dp[ind][buy] = profit;
        return profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int [n][2];
      for (int[] row : dp) Arrays.fill(row, -1);
      return getans(prices, 0,0 ,n,dp);

         
    }
}