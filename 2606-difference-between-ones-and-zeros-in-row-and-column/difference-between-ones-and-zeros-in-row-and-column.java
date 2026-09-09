class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] diff = new int[m][n];
        int[] onerows = new int[m];
        int[] onecols = new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                  onerows[i] +=1;
                  onecols[j]+=1;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int onesRowi = onerows[i];
                int onesColj  = onecols[j];
                int zerosRowi  = m - onerows[i];
                int zerosColj = n - onecols[j];

                diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj ; 

            }
        }
        return diff;
    }
}