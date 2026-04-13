class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int totsum = 0;
        for(int num : nums){
            totsum+=num;
        }

        if((totsum + target)%2!=0 || Math.abs(target)> totsum) return 0;
        int newtarget = (totsum + target)/2;

        int [][] dp  = new int[n+1][newtarget+1]  ;

        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=n;i++){
            for(int j=0;j<=newtarget;j++){
                dp[i][j] = dp[i-1][j];

                if(nums[i-1]<=j){
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[n][newtarget];

  }
}