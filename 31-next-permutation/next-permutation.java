class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int indx = -1;

        // Step 1: find first decreasing element from right
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                indx = i;
                break;
            }
        }

        // Step 2: if found, swap with just greater element
        if (indx != -1) {
            for (int i = n - 1; i > indx; i--) {
                if (nums[i] > nums[indx]) {
                    int temp = nums[i];
                    nums[i] = nums[indx];
                    nums[indx] = temp;
                    break;
                }
            }
        }

        // Step 3: reverse the suffix
        reverse(nums, indx + 1, n - 1);
    }

    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}