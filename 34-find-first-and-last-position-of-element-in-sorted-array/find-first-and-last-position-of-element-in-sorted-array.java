class Solution {
    public int firstoccur(int[] nums, int target){
        int low = 0;
        int n = nums.length;
        int high = n-1;
       int ans1 =-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(nums[mid]==target){
                ans1 =  mid;
                high = mid-1;
            }

            else if(nums[mid]>=target){
               high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans1;
    }

     public int lastoccur(int[] nums, int target){
        int low = 0;
        int n = nums.length;
        int high = n-1;
        int ans2 =-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(nums[mid]==target){
                ans2 =  mid;
                low = mid+1;
            }

            else if(target>nums[mid]){
               
                low = mid+1;
            }
            else{
               high = mid-1;
            }
        }
        return ans2;
    }
    public int[] searchRange(int[] nums, int target) {
        int firstoccur = firstoccur(nums, target);
        int lastoccur = lastoccur(nums, target);
        return new int[]{firstoccur, lastoccur};
    }
}