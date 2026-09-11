class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;

        int[][] mat = new int[m][n];

        int i = 0, j = 0;

        while (i < m && j < n) {
            mat[i][j] = Math.min(rowSum[i], colSum[j]);

            rowSum[i] -= mat[i][j];
            colSum[j] -= mat[i][j];

            if (rowSum[i] == 0) {
                i++;
            }

            if (colSum[j] == 0) {
                j++;
            }
        }

        return mat;
    }
}