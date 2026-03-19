class Solution {
    public int helper(int[] nums, int div){
        int val = 0;
        for(int i=0;i<nums.length;i++){
            val+=(int)Math.ceil((double)nums[i] /(double)div);
        }
        return val;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low =1;
        int high = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
         high = Math.max(nums[i] , high);
        }
        int n = nums.length;
        if(n>threshold){
            return -1;
        }
        while(low<=high){
            int mid = (low+high)/2;
            int totsum = helper(nums, mid);
            if(totsum<=threshold){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}