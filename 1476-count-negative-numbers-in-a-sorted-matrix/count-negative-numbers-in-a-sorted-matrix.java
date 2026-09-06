class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        for(int[] row : grid){
       int low = 0;
       int high = n;

       while(low<high){
      int  mid = low + (high - low)/2;

        if(row[mid]>=0){
            low = mid+1;
        }
        else{
            high = mid;
        }
       }
       result+= (n - low);
        }
        return result ; 
    }
}