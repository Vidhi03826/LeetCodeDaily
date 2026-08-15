class Solution {
    public int longestSubsequence(int[] nums) {

        int n = nums.length;
        int xor = 0;
        int zeroCount = 0;

        for (int num : nums) {
            xor ^= num;

            if (num == 0) {
                zeroCount++;
            }
        }

        // Case 1
        if (xor != 0) {
            return n;
        }

        // Case 3
        if (zeroCount == n) {
            return 0;
        }

        // Case 2
        return n - 1;
    }
}