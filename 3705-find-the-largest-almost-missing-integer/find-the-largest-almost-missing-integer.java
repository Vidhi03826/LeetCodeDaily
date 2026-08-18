class Solution {
    public int largestInteger(int[] nums, int k) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        int n = nums.length;

        // Check every window of size k
        for (int i = 0; i <= n - k; i++) {

            HashSet<Integer> set = new HashSet<>();

            // Put all elements of current window into set
            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            // Count how many windows contain each number
            for (int num : set) {
                mp.put(num, mp.getOrDefault(num, 0) + 1);
            }
        }

        int ans = -1;

        // Find largest number appearing in exactly one window
        for (int num : mp.keySet()) {

            if (mp.get(num) == 1) {
                ans = Math.max(ans, num);
            }
        }

        return ans;
    }
}