class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int[] mp = new int[n+1];;
        for(int num : nums){
         int freq = mp[num];
         if(freq == res.size()){
            res.add(new ArrayList<>());
         }
        res.get(freq).add(num);
         mp[num]++;
      
        }
        return res;
    }
}