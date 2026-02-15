class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int target = 0; target <= amount; target++) {
              
                dp[i][target] = dp[i - 1][target];

                if (coins[i - 1] <= target) {
                    dp[i][target] += dp[i][target - coins[i - 1]];
                }
            }
        }

        return dp[n][amount];
    }
}
