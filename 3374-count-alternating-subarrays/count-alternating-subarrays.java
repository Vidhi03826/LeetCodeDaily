class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        int len = 0;
        int n = nums.length;
        long count = 0;

        for(int i=0;i<nums.length;i++){
            int j = i;

            while(j+1 < n && nums[j+1]!=nums[j]){
                j++;
            }

            len = j-i+1;
            count+=(long) len * (len+1)/2;
            i=j;
        }
        return count;
    }
}