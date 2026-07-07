class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(mp.containsKey(nums[i])){
                int prevIdx = mp.get(nums[i]);

                if(i - prevIdx <=k){
                    return true;
                }
            }

            mp.put(nums[i], i);
        }
        return false;
    }
}