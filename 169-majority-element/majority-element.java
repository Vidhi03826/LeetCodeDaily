class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int el=0;
        int n= nums.length;

        for(int i =0;i<nums.length; i++) {
            if(count==0) {
                count =1;
                el =nums[i];
            }
            else if(el == nums[i]) {
                count ++;
            }
            else {
                count--;
            }

        }
         int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el) {
                cnt1++;
            }
        }
        
        //return element if it is a majority element
        if (cnt1 > (n / 2)) {
            return el;
        }
        
        //return -1 if no such element found
        return -1;

    }
}