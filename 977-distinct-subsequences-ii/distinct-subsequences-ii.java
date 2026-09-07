class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int[] last = new int[26];

        long total = 0;

        for (char ch : s.toCharArray()) {
            int curr = (int)((total + 1) % MOD);

            // Remove subsequences already created with this character
            total = (total + curr - last[ch - 'a'] + MOD) % MOD;

            // Update the latest contribution of this character
            last[ch - 'a'] = curr;
        }

        return (int) total;
    }
}