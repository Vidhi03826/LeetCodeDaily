class Solution {
    
    public void solve(char[][] board) {
        int m = board.length;
        int n= board[0].length;
        int [] delrow = {-1,0,1,0};
        int [] delcol = {0,1,0,-1};

        int [][] vis = new int[m][n];

        //marking first row and last col
        for(int j=0;j<n;j++){
           if(vis[0][j]==0 && board[0][j]=='O'){
           dfs(0, j, board, vis,delrow, delcol, m , n);
           } 
          if(vis[m-1][j]==0 && board[m-1][j]=='O'){
           dfs(m-1, j, board, vis,delrow, delcol, m , n);
           } 
        }

        //marking last ro
         for(int i=0;i<m;i++){
           if(vis[i][0]==0 && board[i][0]=='O'){
             dfs(i, 0, board, vis,delrow, delcol, m , n);
           } 
          if(vis[i][n-1]==0 && board[i][n-1]=='O'){
            dfs(i, n-1, board, vis,delrow, delcol, m , n);
           } 
        }
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
       if(vis[i][j]==0 && board[i][j] =='O'){
        board[i][j] ='X';
        
       }
        }     
  }


    }

    public void dfs(int row, int col, char[][] board, int[][] vis, int[] delrow, int[] delcol, int m ,int n){
        vis[row][col]= 1;
        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
          if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
          dfs(nrow, ncol, board, vis,delrow, delcol, m , n);
          } 
        }
    }
}