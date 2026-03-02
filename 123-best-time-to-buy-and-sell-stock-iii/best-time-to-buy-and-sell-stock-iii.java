class Solution {
    public int getans(int[] prices, int ind, int buy, int n,int cap, int [][][] dp){
          if (ind == n || cap == 0)
            return 0;

        if(dp[ind][buy][cap]!=-1) return dp[ind][buy][cap];
        int profit;

        if(buy==0){//can buy
          profit = Math.max((-prices[ind] + getans(prices, ind+1,1 ,n, cap, dp)) , getans(prices, ind+1,0 ,n,cap,dp));
        }
        else {//cant buy
            profit=  Math.max((prices[ind] + getans(prices, ind+1,0 ,n,cap-1,dp)) , getans(prices, ind+1,1 ,n,cap,dp));
        }
        dp[ind][buy][cap] = profit;
        return profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int [][][] dp = new int [n][2][3];
     for(int i=0;i<n;i++){
        for(int j=0;j<2;j++){
            Arrays.fill(dp[i][j] , -1);
        }
     }
      return getans(prices, 0,0 ,n,2,dp);

         
    }
}