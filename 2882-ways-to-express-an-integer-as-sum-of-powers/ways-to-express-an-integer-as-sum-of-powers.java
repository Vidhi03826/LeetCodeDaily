
import java.util.*;

class Solution {
    static final int M = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        int[][] dp = new int[301][301]; 

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n, 1, x, dp);
    }

    public int solve(int n, int num, int x, int[][] dp) {
        if (n == 0) {
            return 1;
        }

        if (n < 0 || num > n) {
            return 0;
        }

        if (dp[n][num] != -1) {
            return dp[n][num];
        }

        long currpow = 1;
        for (int i = 0; i < x; i++) {
            currpow *= num;

            if (currpow > n) {
                return dp[n][num] = solve(n, num + 1, x, dp);
            }
        }

        int take = solve(n - (int) currpow, num + 1, x, dp);
        int skip = solve(n, num + 1, x, dp);

        return dp[n][num] = (int) (((long) take + skip) % M);
    }
}
