
class Solution {
    static final int MOD = 1_000_000_007;
    public int checkRecord(int n) {
        int dp[][][] = new int[n+1][2][3];
        for (int[][] row2D : dp) {
        for (int[] row1D : row2D) {
        Arrays.fill(row1D, -1);
    }
}
        return solve(n, 0, 0,dp);
    }

    public int solve(int n, int absentDays, int consecutiveLate ,  int dp[][][] ) {
        if (n == 0) {
            return 1; // found 1 valid

        }

        if(absentDays>1 || consecutiveLate >2) return 0;
        if(dp[n][absentDays][consecutiveLate] !=-1){
            return  dp[n][absentDays][consecutiveLate];
        }

        int A = 0, P = 0, L = 0;

        // A: At most one absence
        if (absentDays < 1) {
            A = solve(n - 1, absentDays + 1, 0 ,dp);
        }

        // P: Present, resets consecutive late count
        P = solve(n - 1, absentDays, 0 ,dp);

        // L: Late, at most two consecutive late days
        if (consecutiveLate < 2) {
            L = solve(n - 1, absentDays, consecutiveLate + 1 ,dp);
        }

        return dp[n][absentDays][consecutiveLate] =  (int) (((long) A + P + L) % MOD);
    }
}
