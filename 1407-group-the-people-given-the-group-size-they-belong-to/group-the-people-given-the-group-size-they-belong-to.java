class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();
        int n = groupSizes.length;
        for(int i=0;i< n ;i++){
         int key = groupSizes[i];

         mp.putIfAbsent(key , new ArrayList<>());
         mp.get(key).add(i);

         //if grp is full
         if(mp.get(key).size()== key){
            ans.add(mp.get(key));
            mp.put(key , new ArrayList<>());
         }
        }
        return ans;
    }
}