class Solution {

    public boolean helper(int[] nums, int target, int[][] dp, int i) {

        if (target == 0) return true;
        if (i == 0) return nums[0] == target;

        if (dp[i][target] != -1)
            return dp[i][target] == 1;

        boolean notTake = helper(nums, target, dp, i - 1);
        boolean take = false;

        if (nums[i] <= target) {
            take = helper(nums, target - nums[i], dp, i - 1);
        }

        dp[i][target] = (notTake || take) ? 1 : 0;
        return notTake || take;
    }

    public boolean canPartition(int[] nums) {

        int n = nums.length;
        int totsum = 0;

        for (int x : nums) totsum += x;

        if (totsum % 2 != 0) return false;

        int target = totsum / 2;
        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(nums, target, dp, n - 1);
    }
}
