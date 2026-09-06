class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> rows = new ArrayList<>();

            for(int j=0;j<=i;j++){
            if(j==0 || j==i){
                rows.add(1);
            }
            else{
                rows.add(ans.get(i-1).get(j) + ans.get(i-1).get(j-1));
            }
            }
            ans.add(rows);
        }
        return ans;
    }
}