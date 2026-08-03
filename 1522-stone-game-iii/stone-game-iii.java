class Solution {

    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;

        // dp[i] = maximum score difference starting from index i
        int[] dp = new int[n + 1];

        // Base case:
        // dp[n] = 0 because no stones are left
        dp[n] = 0;

        // Fill from back because dp[i] depends on dp[i+1], dp[i+2], dp[i+3]
        for (int i = n - 1; i >= 0; i--) {

            // Start with the smallest possible value
            dp[i] = Integer.MIN_VALUE;

            // Sum of stones taken in current move
            int sum = 0;

            // Try taking 1, 2 and 3 stones
            for (int k = 0; k < 3 && i + k < n; k++) {

                // Add current stone to the running sum
                sum += stoneValue[i + k];

                /*
                   Current player's difference

                   =
                   Current collected stones
                   -
                   Opponent's best difference
                */
                dp[i] = Math.max(dp[i], sum - dp[i + k + 1]);
            }
        }

        // Decide winner based on final score difference
        if (dp[0] > 0)
            return "Alice";

        if (dp[0] < 0)
            return "Bob";

        return "Tie";
    }
}