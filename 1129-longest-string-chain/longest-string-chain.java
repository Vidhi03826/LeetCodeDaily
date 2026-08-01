class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;

        Arrays.sort(words, Comparator.comparingInt(String::length));

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxlen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (checkpossible(words[i], words[j]) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (maxlen < dp[i]) {
                maxlen = dp[i];
            }
        }
        return maxlen;
    }

    private boolean checkpossible(String s, String t) {
        if (s.length() != t.length() + 1) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (j < t.length() && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;

            } else {
                i++;
            }
        }
        return (i == s.length() && j == t.length());
    }
}