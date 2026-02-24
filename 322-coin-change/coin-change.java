class Solution {
    public int helper(int[] coins, int amount, int idx, int [][] dp ){
        if(idx==0){
            if(amount%coins[0]==0) return amount / coins[0];
            
            
   return (int) 1e9;
        }
      

        if(dp[idx][amount] !=-1) return dp [idx][amount];

        int nottake = helper(coins, amount, idx-1, dp );
        int take = (int ) 1e9;
        if(coins[idx]<=amount){
            take = 1 + helper(coins, amount - coins[idx], idx,dp );
        }

        return dp[idx][amount]= Math.min(take, nottake);
    }
    public int coinChange(int[] coins, int amount) {
        int [][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j] =-1;
            }
        }

        int ans =  helper(coins, amount, coins.length-1, dp);
        if(ans>= (int)1e9) return -1;
        return ans;
    }
}