import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        long[] diff = new long[n];
        long maxDiff = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs((long) nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            total += diff[i];
        }

        // If all differences can be reduced to zero
        if (total <= k) {
            return 0;
        }

        long low = 0, high = maxDiff;

        // Find the minimum possible maximum difference
        while (low < high) {
            long mid = low + (high - low) / 2;
            long ops = 0;

            for (long d : diff) {
                if (d > mid) {
                    ops += d - mid;
                }
            }

            if (ops <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        // Reduce every difference to at most low
        long ans = 0;
        long used = 0;

        for (long d : diff) {
            if (d > low) {
                used += d - low;
                d = low;
            }
            ans += d * d;
        }

        // Distribute remaining operations to reduce the largest values
        long remaining = k - used;

        if (remaining > 0) {
            // Each remaining operation reduces one value equal to low by 1.
            // Correctly account for the reduction in squared sum.
            ans -= remaining * (2 * low - 1);
        }

        return ans;
    }
}