class Solution {
    public int[][] floodFill(int[][] image, int row, int col, int color) {
        int m = image.length;
        int n= image[0].length;
   
        int[][] ans = image;
         int inicolor =  ans[row][col] ;
         int [] delrow = {-1,0,+1,0};
         int [] delcol = {0,1,0,-1};

        dfs(row, col,image,ans, delrow,delcol,color,inicolor,m,n);
         return ans;
        }
        public void dfs(int row, int col, int[][] image,int[][] ans, int [] delrow,int[] delcol, int color, int inicolor, int m , int n){
        ans[row][col] = color;
        for(int i = 0;i<4;i++){
            int nrow = delrow[i] + row;
            int ncol = delcol[i] + col;

            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && 
            image[nrow][ncol]== inicolor && ans[nrow][ncol]!=color){
               dfs(nrow, ncol,image,ans, delrow,delcol,color,inicolor,m,n);
            }
        }
        }
}