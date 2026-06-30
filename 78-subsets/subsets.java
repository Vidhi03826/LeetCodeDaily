class Solution {

    public void helper(int idx, int[] nums,
                       List<Integer> ds,
                       List<List<Integer>> ans) {

        if (idx == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        // Pick
        ds.add(nums[idx]);
        helper(idx + 1, nums, ds, ans);

        // Backtrack
        ds.remove(ds.size() - 1);

        // Not Pick
        helper(idx + 1, nums, ds, ans);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), ans);

        return ans;
    }
}