class Solution {
            int[][] dirs = {{1,1} , {1 , -1} ,{-1, -1} , {-1 ,1}};

    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==1){
               for(int d = 0; d<=3 ;d++){
            result = Math.max(result , 1+ solve(i , j , d , grid , true , 2));
        }
                }
            }
        }
        return result;
        
    }

    public int solve(int i , int j , int d , int [][] grid , boolean canturn, int val){
        int m = grid.length;
        int n = grid[0].length;
        int newi = i + dirs[d][0];
        int newj = j+ dirs[d][1];
        int result = 0;

        if(newi >= m || newi<0 || newj>=n || newj<0 || grid[newi][newj]!=val){
            return 0;
        }
        int keepmoving = 1 + solve(newi , newj, d ,grid,  canturn , val==2 ? 0 : 2);
        result = Math.max(result , keepmoving);
        
        if(canturn ==true){
        int taketurn =1 + solve(newi , newj , (d+1)%4 , grid , false , val==2 ? 0 : 2);
       result = Math.max(result , taketurn);
      
        }
        return result;
    }
}