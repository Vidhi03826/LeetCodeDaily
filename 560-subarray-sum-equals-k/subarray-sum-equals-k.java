class Solution {
    public int subarraySum(int[] nums, int k) {
        int n =nums.length;
        int count = 0;
        int prefixsum =0;
        Map<Integer , Integer> mp = new HashMap<>();
       mp.put(0 , 1);
     
      for(int i=0;i<nums.length ; i++){
      prefixsum+=nums[i];

      int val = prefixsum  - k;

      if(mp.containsKey(val)!=false){
        count+=mp.get(val);
      }
      mp.put(prefixsum , mp.getOrDefault(prefixsum ,0)+1);
      }
      return count;
    }
}