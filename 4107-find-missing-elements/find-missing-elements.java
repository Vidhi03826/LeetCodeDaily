class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i =0;i<nums.length;i++){

            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);

        }
        
        Set<Integer> set = new HashSet<>();

        for(int num :nums){
           set.add(num);
        }

        for(int i =min ; i<max;i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}