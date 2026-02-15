class Solution {
    public int helper(int i, int j, int[] nums, int[] dp){
      
    
       if(i>j) return  0;
      if(dp[i]!=-1) return dp[i];
       int pick = nums[i] +  helper(i+2,  j, nums,dp);
       int notpick = helper(i+1,  j, nums,dp);
       return dp[i] = Math.max(pick , notpick);
       

    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
          int [] dp = new int[nums.length];
        //case 1
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = helper(0,  n-2, nums,dp1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = helper(1,  n-1, nums,dp2);
        return Math.max(case1, case2);
    }
}