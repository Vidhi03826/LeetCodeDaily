class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;

        for(int num : nums){
            left  = Math.max(left , num);
            right +=num;
        }
        int ans = right;

        while(left<=right){
            int mid = left+ (right - left)/2;

            if(canSplit(nums , k , mid)){
                ans = mid ;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return ans ;
    } 

    public boolean canSplit(int[] nums, int m , int maxsum){
        int subarrays =1;
        int sum = 0;

        for(int num : nums){
            if(sum+num<= maxsum){
                sum+=num;
            }
            else{
                subarrays++;
                sum = num;
            }
        }
        return subarrays<=m;
    }
}