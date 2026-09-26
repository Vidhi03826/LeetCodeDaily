class Solution {
    public int longestSubarray(int[] nums) {
        int maxval = 0;
        int streak = 0;
        int res = 0;
        for(int num : nums){
        if(num > maxval){
            maxval=num;
            streak = 0;
            res = 0;
        }
        if(num==maxval){
            streak++;

        }else{
            streak = 0;
        }
      res = Math.max(res , streak);
        }
        return res;
     
        
    }
}