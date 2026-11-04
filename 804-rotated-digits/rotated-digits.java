
class Solution {
    public int rotatedDigits(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (solve(i) == 1) {
                count++;
            }
        }

        return count;
    }

    public int solve(int num) {
        if (num == 0) {
            return 0;
        }

        int remain = solve(num / 10);
        int digit = num % 10;

        int digitCheck;

        if (digit == 0 || digit == 1 || digit == 8) {
            digitCheck = 0;
        }
        else if (digit == 2 || digit == 5 ||
                 digit == 6 || digit == 9) {
            digitCheck = 1;
        }
        else {
            return 2;
        }

        if (remain == 2 || digitCheck == 2) {
            return 2;
        }

        if (remain == 1 || digitCheck == 1) {
            return 1;
        }

        return 0;
    }
}
