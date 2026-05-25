class Solution {
    public void sortColors(int[] nums) {
         int low = 0, mid = 0, high = nums.length- 1;

        // Process elements until mid pointer crosses high pointer
        while (mid <= high) {
            // If current element is 0, swap with low and move both pointers forward
            if (nums[mid] == 0) {
               int temp =nums[mid];
               nums[mid] = nums[low];
               nums[low]= temp;

                mid++;
                low++;
            }
            // If current element is 1, it's already in correct place → move mid forward
            else if (nums[mid] == 1) {
                mid++;
            }
            // If current element is 2, swap with high and move only high pointer backward
            else {
                int temp =nums[mid];
               nums[mid] = nums[high];
               nums[high]= temp;
                high--;
            }
        }
    }
}