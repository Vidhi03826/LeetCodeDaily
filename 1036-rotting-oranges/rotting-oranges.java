class Solution {
    static class Pair {
        int row, col, time;
        
        Pair(int r, int c, int t) {
            row = r;
            col = c;
            time = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q  = new LinkedList<>();
        int  m = grid.length;
        int n = grid[0].length;
          int vis[][] = new int[m][n];
        int cntfrsh =0;
        for(int i=0; i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==2){
                    vis[i][j]=2;
                    q.add(new Pair(i,j,0));
                }
                else {
                    vis[i][j] = 0;
                }
                if(grid[i][j]==1) {
                    cntfrsh ++;
                }
            }
        }
        int[] delrow = {-1,0,1,0};
        int count=0;
        int[] delcol = {0,-1,0,1};
        int time = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            q.poll();
            time = Math.max(time, t);

        for(int i=0;i<4;i++){
            int nrow = r + delrow[i];
            int ncol = c + delcol[i];

            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n
            && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1) {
                vis[nrow][ncol] =2;
                q.add(new Pair(nrow, ncol, t+1));
                count++;

            }
        }
        }
        if(count!=cntfrsh) return -1;
        return time;
    }
}