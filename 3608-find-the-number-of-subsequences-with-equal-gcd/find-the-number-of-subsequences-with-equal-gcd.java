
import java.util.*;

class Solution {
    int MOD = 1_000_000_007;
    int[][][] dp;

    public int subsequencePairCount(int[] nums) {
        int maxel = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            maxel = Math.max(maxel, nums[i]);
        }

        dp = new int[n + 1][maxel + 1][maxel + 1];

        for (int[][] rows : dp) {
            for (int[] col : rows) {
                Arrays.fill(col, -1);
            }
        }

        return solve(0, 0, 0, nums);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int solve(int i, int first, int second, int[] nums) {

        if (i == nums.length) {
            boolean bothNonEmpty = first != 0 && second != 0;
            boolean gcdMatch = first == second;

            return (bothNonEmpty && gcdMatch) ? 1 : 0;
        }

        if (dp[i][first][second] != -1) {
            return dp[i][first][second];
        }

        // Choice 1: Skip current element
        int skip = solve(i + 1, first, second, nums);

        // Choice 2: Put current element in first subsequence
        int take1 = solve(i + 1, gcd(first, nums[i]), second, nums);

        // Choice 3: Put current element in second subsequence
        int take2 = solve(i + 1, first, gcd(second, nums[i]), nums);

        return dp[i][first][second] =
            (int)((0L + skip + take1 + take2) % MOD);
    }
}
