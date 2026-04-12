class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarray(nums, k) -subarray(nums, k-1);
    }
    public int subarray(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int l=0;
        int count=0;
        for(int r=0;r<nums.length;r++){
            mpp.put(nums[r], mpp.getOrDefault(nums[r],0) +1);
        

       while(mpp.size()>k){
           mpp.put(nums[l], mpp.get(nums[l]) -1);
          
          if(mpp.get(nums[l]) == 0){
            mpp.remove(nums[l]);
          }
          l++;
            
        }
         count+=(r-l+1);
        }
       
     return count;
    }

    


}