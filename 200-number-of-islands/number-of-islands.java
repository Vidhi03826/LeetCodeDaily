class Solution {
    public int numIslands(char[][] grid) {
        int count =0;
        int m = grid.length;
        int n = grid[0].length;
        int [] delrow = {-1,0,1,0};
        int [] delcol  = {0,-1,0,1};
        boolean[][] vis = new boolean [m][n]; 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]== false && grid[i][j]=='1'){
                    bfs(i, j, vis, grid, delrow, delcol, m , n);
                    count++;
                }
            }
        }
        return count;
    }

    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    private void bfs(int i, int j, boolean[][] vis, char[][]grid, int[] delrow, int[]delcol, int m, int n){
        vis[i][j]=true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));

        while(!q.isEmpty()){
            Pair front = q.remove();
            int row = front.row;
            int col = front.col;

            for(int d=0;d<4;d++){
                int nrow = row + delrow[d];
                int ncol = col + delcol[d];
             if(nrow>=0 && nrow<m && ncol>=0 && ncol <n && vis[nrow][ncol]==false && grid[nrow][ncol]=='1'){
                vis[nrow][ncol] = true;
                q.add(new Pair(nrow, ncol));
             }

            }


        }
        
     }
}