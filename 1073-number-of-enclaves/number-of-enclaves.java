class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
                 int count = 0;
         boolean vis[][] = new boolean[m][n];
         

        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if((i==0 || i==m-1 ||j==0 ||j==n-1) && grid[i][j] ==1){
                    q.offer(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }

        int[] delrow = {-1,0,+1,0};
        int[]delcol = {0,-1, 0, +1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row =curr[0];
            int col =curr[1];
            
            for(int i = 0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                  if(nrow>0 && nrow<m & ncol>=0 && ncol<n && vis[nrow][ncol]==false && grid[nrow][ncol]==1){
                 vis[nrow][ncol]=true;
                 q.offer(new int[]{nrow, ncol});
            }
            }
          

        }
       for(int i =0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==1 && vis[i][j]== false){
                count++;
            }
        }
       }

       return count;
    }
}