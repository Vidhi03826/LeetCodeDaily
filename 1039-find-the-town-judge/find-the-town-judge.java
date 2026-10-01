class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] indeg = new int[n+1];
        int [] outdeg = new int[n+1];
        int ans = -1;

        for(int[] rel : trust){
            int u = rel[0];
            int v = rel[1];

            outdeg[u]++;
            indeg[v]++;
        }

        for(int i=0;i<=n;i++){
            if(indeg[i]==n-1 && outdeg[i]==0){
                 ans = i;
            }
        }
        return ans;
    }
}