class Solution {
    int MOD = 1_000_000_007;
    int[][][] dp;

    public int numberOfStableArrays(int zero, int one, int limit) {

        dp = new int[one + 1][zero + 1][2];

        for (int i = 0; i <= one; i++) {
            for (int j = 0; j <= zero; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        int zerostart = solve(one, zero, limit, false);
        int onestart = solve(one, zero, limit, true);

        return (zerostart + onestart) % MOD;
    }

    public int solve(int onesleft, int zeroesleft, int limit,
                     boolean lastwasone) {

        if (onesleft == 0 && zeroesleft == 0) {
            return 1;
        }

        int state = lastwasone ? 1 : 0;

        if (dp[onesleft][zeroesleft][state] != -1) {
            return dp[onesleft][zeroesleft][state];
        }

        long result = 0;

        if (lastwasone) {

            // Ab 0s place karne hain
            for (int len = 1;
                 len <= Math.min(zeroesleft, limit);
                 len++) {

                result += solve(
                    onesleft,
                    zeroesleft - len,
                    limit,
                    false
                );

                result %= MOD;
            }

        } else {

            // Ab 1s place karne hain
            for (int len = 1;
                 len <= Math.min(onesleft, limit);
                 len++) {

                result += solve(
                    onesleft - len,
                    zeroesleft,
                    limit,
                    true
                );

                result %= MOD;
            }
        }

        return dp[onesleft][zeroesleft][state] = (int) result;
    }
}