class Solution {
    public int findDuplicate(int[] nums) {
        int slow  = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);

        int ptr = nums[0];
        while(ptr!=slow){
            ptr = nums[ptr];
            slow = nums[slow];
        }
        return ptr;

    }
}