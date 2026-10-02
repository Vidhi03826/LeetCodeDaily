class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean inc = false;
        boolean dec = false;
        for(int i =0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                inc =true;
            }

           if(nums[i]> nums[i+1]){
            dec= true;
           }
        }
        if(dec == true && inc ==true){
            return false;
        }
        return true;
    }

}