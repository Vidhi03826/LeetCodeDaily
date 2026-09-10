class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        Map<Integer, Integer> mp = new HashMap<>();

        mp.put(0, 1);

        int oddCount = 0;
        int count = 0;

        for (int num : nums) {

            if (num % 2 != 0) {
                oddCount++;
            }

            int required = oddCount - k;

            if (mp.containsKey(required)) {
                count += mp.get(required);
            }

            mp.put(oddCount, mp.getOrDefault(oddCount, 0) + 1);
        }

        return count;
    }
}