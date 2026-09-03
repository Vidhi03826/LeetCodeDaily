class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int minodd = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            if(nums1[i]%2 !=0){
              minodd = Math.min(minodd , nums1[i]);
            }
        }

        if(minodd==Integer.MAX_VALUE){
            return true;
        }

        for(int i = 0;i<n;i++){
            if(nums1[i]%2==0 && nums1[i] < minodd){
                return false;
                
            }
        }
        return true;
    }
}