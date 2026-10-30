
class Solution {
    int M = 1_000_000_007;
    int[][] dp;

    String[] states = {
        "RYG", "RGY", "RYR", "RGR",
        "YRG", "YGR", "YGY", "YRY",
        "GRY", "GYR", "GRG", "GYG"
    };

    public int numOfWays(int n) {
        dp = new int[n][12];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 12; j++) {
                dp[i][j] = -1;
            }
        }

        int result = 0;

        for (int i = 0; i < 12; i++) {
            result = (result + solve(n - 1, i)) % M;
        }

        return result;
    }

    public int solve(int n, int previdx) {
        if (n == 0) {
            return 1;
        }

        if (dp[n][previdx] != -1) {
            return dp[n][previdx];
        }

        String last = states[previdx];
        int result = 0;

        for (int curr = 0; curr < 12; curr++) {
            String currpattern = states[curr];
            boolean valid = true;

            for (int col = 0; col < 3; col++) {
                if (currpattern.charAt(col) == last.charAt(col)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result = (result + solve(n - 1, curr)) % M;
            }
        }

        return dp[n][previdx] = result;
    }
}
