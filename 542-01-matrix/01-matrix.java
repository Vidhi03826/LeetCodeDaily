class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j,0});
                    vis[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.remove();
            int row = curr[0];
            int col = curr[1];
            int steps = curr[2];

            dist[row][col] = steps;

            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow>=0 && nrow<m & ncol>=0 && ncol<n && !vis[nrow][ncol]){
                    q.add(new int[]{nrow , ncol , steps+1});
                    vis[nrow][ncol] = true;
                }
            }
        }
        return dist;
    }
}