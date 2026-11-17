class Solution {
    public int minimumChanges(String s, int k) {

        int n = s.length();

        // cost[i][j] = minimum changes to make s[i...j]
        // a semi-palindrome
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {

                int j = i + len - 1;
                cost[i][j] = Integer.MAX_VALUE;

                // Find proper divisors of substring length
                for (int d = 1; d < len; d++) {

                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    // Check each group of characters
                    for (int r = 0; r < d; r++) {

                        int left = i + r;
                        int right = i + r + ((len - 1 - r) / d) * d;

                        while (left < right) {

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    cost[i][j] = Math.min(cost[i][j], changes);
                }
            }
        }

        // DP: dp[i][p] = minimum changes to divide
        // first i characters into p semi-palindromes
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int p = 0; p <= k; p++) {
                dp[i][p] = Integer.MAX_VALUE / 2;
            }
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int p = 1; p <= k; p++) {

                for (int j = p - 1; j < i; j++) {

                    if (i - j < 2) {
                        continue;
                    }

                    dp[i][p] = Math.min(
                        dp[i][p],
                        dp[j][p - 1] + cost[j][i - 1]
                    );
                }
            }
        }

        return dp[n][k];
    }
}