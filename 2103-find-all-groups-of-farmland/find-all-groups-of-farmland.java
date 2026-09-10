class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<int[]> res = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

            if(land[i][j]==1){
              int startrow = i;
              int startcol = j;

              int endrow = i;
              int endcol = j;

              q.add(new int[]{i,j});
              land[i][j]=0;

              while(!q.isEmpty()){
                int[] curr = q.remove();
                int row = curr[0];
                int col = curr[1];

                endrow = Math.max(row , endrow);
                endcol = Math.max(col , endcol);

                for(int k=0;k<4;k++){
                    int nrow = row + delrow[k];
                    int ncol = col + delcol[k];

                    if(nrow>=0 && nrow<m && ncol>=0 && ncol<n
                    && land[nrow][ncol]==1){
                        q.add(new int[]{nrow , ncol});
                        land[nrow][ncol]=0;
                    }
                }
              }

              res.add(new int[] { startrow , startcol, endrow , endcol});

            }
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}