class Solution {
    public boolean getHammingDist(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }

        }
        return diff == 1;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int parent[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int LIS = 1;
        int lisIdx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && words[i].length() == words[j].length()
                        && getHammingDist(words[i], words[j])) {
                    if (1 + dp[j] > dp[i]) {
                        dp[i] = 1 + dp[j];
                        parent[i] = j;
                    }

                }
                if (dp[i] > LIS) {
                    LIS = dp[i];
                    lisIdx = i;

                }

            }

        }
        List<String> result = new ArrayList<>();
        while (lisIdx != -1) {
            result.add(words[lisIdx]);

            lisIdx = parent[lisIdx];
        }

        Collections.reverse(result);
        return result;
    }
}