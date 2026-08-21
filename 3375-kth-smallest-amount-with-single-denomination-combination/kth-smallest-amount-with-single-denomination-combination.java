class Solution {

    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;

        long low = 1;
        long high = (long) coins[0] * k;

        // Binary Search
        while (low < high) {
            long mid = low + (high - low) / 2;

            long count = countNumbers(mid, coins, n);

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // Count how many valid numbers are <= x
    private long countNumbers(long x, int[] coins, int n) {
        long count = 0;

        // Iterate through all non-empty subsets
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;
            boolean possible = true;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {
                    bits++;

                    lcm = getLCM(lcm, coins[i]);

                    // If LCM is greater than x,
                    // this subset contributes 0
                    if (lcm > x) {
                        possible = false;
                        break;
                    }
                }
            }

            if (!possible) {
                continue;
            }

            long multiples = x / lcm;

            // Inclusion-Exclusion
            if (bits % 2 == 1) {
                count += multiples;
            } else {
                count -= multiples;
            }
        }

        return count;
    }

    private long getLCM(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}