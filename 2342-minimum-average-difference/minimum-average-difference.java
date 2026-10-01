class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;

        long totsum = 0;
        long leftsum = 0;
        long rightsum;

        long leftavg;
        long rightavg;

        int res = Integer.MAX_VALUE;
        int idx = -1;

        for (int i = 0; i < n; i++) {
            totsum += nums[i];
        }

        for (int i = 0; i < n; i++) {

            leftsum += nums[i];
            rightsum = totsum - leftsum;

            int nl = i + 1;
            int nr = n - nl;

            leftavg = leftsum / nl;

            if (nr == 0) {
                rightavg = 0;
            } else {
                rightavg = rightsum / nr;
            }

            long val = Math.abs(leftavg - rightavg);

            if (res > val) {
                res = (int) val;
                idx = i;
            }
        }

        return idx;
    }
}