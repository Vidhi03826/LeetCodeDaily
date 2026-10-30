class Solution {
    public int minDeletionSize(String[] strs) {
        int row = strs.length;
        int cols = strs[0].length();
        int lis = 1;

        int dp[] = new int[cols];
        for (int i = 0; i < cols; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < i; j++) {
                //traversng in all the strings
                boolean valid = true;

                for (int k = 0; k < row; k++) {
                    if (strs[k].charAt(j) > strs[k].charAt(i)) {
                        valid = false;
                        break;
                    }

                }
                if (valid) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);

                }

            }
            lis = Math.max(lis, dp[i]);

        }
        return cols - lis;
    }
}