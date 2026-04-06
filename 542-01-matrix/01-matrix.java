class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int [] > q = new LinkedList<>();
        int[][] dist = new int[m][n];
        boolean [][] vis = new boolean[m][n];

        //push all zeroes in the q
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] ==0){
                   q.offer(new int[]{i,j,0});
                   vis[i][j] = true;
                }
            }
        }
        int[] delrow = {-1,0,+1,0};
        int [] delcol = {0,1,0,-1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int steps = curr[2];
            dist[row][col] =steps;

            for(int i=0;i<4;i++){
             
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];
                    

                    if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==false){
                        vis[nrow][ncol]=true;
                        q.offer(new int[]{nrow, ncol, steps+1});
                    }
                
            }
        }
        return dist;
    }
}