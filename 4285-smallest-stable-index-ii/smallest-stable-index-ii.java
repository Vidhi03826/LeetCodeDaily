class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] lmax = new int[n];
        int[] rmin = new int[n];

        //filing lmax
        lmax[0] = nums[0];
        for(int i=1;i<n;i++){
            lmax[i] = Math.max(lmax[i-1] , nums[i]);
        }

        rmin[n-1] = nums[n-1];
        for(int i=n-2; i>=0;i--){
            rmin[i] = Math.min(rmin[i+1] , nums[i]);
        }

        for(int i =0;i<n;i++){
            if(lmax[i] - rmin[i] <=k){
                return i;
            }
        }
        return -1;


    }
}