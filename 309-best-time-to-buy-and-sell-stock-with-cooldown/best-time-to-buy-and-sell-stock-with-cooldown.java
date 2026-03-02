

class Solution {
    public int getans (int[] prices, int idx,int buy, int n, int [][] dp){
        if(idx>=n)return 0;
         int profit ;

          if(dp[idx][buy]!=-1) return dp[idx][buy];

         if(buy==0){
            profit = Math.max((-prices[idx] +  getans (prices, idx+1, 1, n, dp)),
                                   0         +   getans (prices, idx+1, 0, n, dp));
         }
         else{
             profit = Math.max((prices[idx] +  getans (prices, idx+2, 0, n, dp)),
                                   0         +   getans (prices, idx+1, 1, n, dp));
         }
         dp[idx][buy] = profit;
         return profit;
        
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int [n][2];
      for(int [] row: dp){
        Arrays.fill(row, -1);
      }
        return getans (prices, 0, 0, n, dp);
    }
}