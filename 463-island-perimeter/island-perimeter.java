class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean found = false;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j});
                    grid[i][j] =2;
                    found = true;
                    break;
                }
            }
        }

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        while(!q.isEmpty()){
            int[] curr = q.remove();
            int row = curr[0];
            int col = curr[1];
            
            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow<0 || nrow>=m || ncol<0 || ncol >=n){
                    perimeter++;
                }
                else if(grid[nrow][ncol]==0){
                    perimeter++;
                }
                else if(grid[nrow][ncol]==1){
                    grid[nrow][ncol]=2;
                    q.add(new int[]{nrow, ncol});
                }
            }

            
        }
        return perimeter;
    }
}