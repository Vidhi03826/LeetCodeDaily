class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        // Calculate total prefix sum
        int prefixSum = 0;
        for (int stone : stones) {
            prefixSum += stone;
        }

        // Initially, the only possible choice is taking all stones
        int dp = prefixSum;

        // Move from right to left
        for (int i = n - 2; i >= 1; i--) {
            prefixSum -= stones[i + 1];

            dp = Math.max(dp, prefixSum - dp);
        }

        return dp;
    }
}