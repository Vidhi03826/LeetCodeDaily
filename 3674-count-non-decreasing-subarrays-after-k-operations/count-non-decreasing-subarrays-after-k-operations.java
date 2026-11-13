import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();

        long cost = 0;
        long ans = 0;

        int j = n - 1;

        for (int i = n - 1; i >= 0; i--) {

            // Merge smaller elements into the current larger element
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {

                int l = dq.pollLast();

                int r = dq.isEmpty() ? j + 1 : dq.peekLast();

                cost += (long) (r - l) * (nums[i] - nums[l]);
            }

            dq.offerLast(i);

            // Reduce window size if cost exceeds k
            while (cost > k) {

                int r = dq.peekFirst();

                cost -= nums[r] - nums[j];

                if (r == j) {
                    dq.pollFirst();
                }

                j--;
            }

            // Count all valid subarrays starting at i
            ans += j - i + 1;
        }

        return ans;
    }
}