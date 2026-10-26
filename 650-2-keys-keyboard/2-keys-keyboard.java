
class Solution {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        return solve(1, 0, n);
    }

    public int solve(int currA, int clipA, int n) {
        if (currA == n) {
            return 0;
        }

        if (currA > n) {
            return 10000;
        }

        int copyAllPaste = 10000;
        int paste = 10000;

        // Copy All, then Paste
        if (currA * 2 <= n) {
            copyAllPaste = 2 + solve(currA * 2, currA, n);
        }

        // Paste only when clipboard is not empty
        if (clipA > 0 && currA + clipA <= n) {
            paste = 1 + solve(currA + clipA, clipA, n);
        }

        return Math.min(copyAllPaste, paste);
    }
}
