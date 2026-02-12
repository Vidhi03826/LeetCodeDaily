class Solution {
     private int func(String s1, String s2) {
        // Length of first string
        int n = s1.length();
        // Length of second string
        int m = s2.length();

        // 2D DP array: dp[i][j] stores LCS length of s1[0..i-1] and s2[0..j-1]
        int[][] dp = new int[n + 1][m + 1];

        // Initialize first row to 0 (when one string is empty)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        // Initialize first column to 0 (when the other string is empty)
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        // Fill DP table
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                // If current characters match, add 1 to the LCS of previous characters
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                } 
                // If they don't match, take the max by ignoring one character from either string
                else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }

        // LCS length is stored in the bottom-right cell
        return dp[n][m];
    }

    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        return func(s, t);
    }
}