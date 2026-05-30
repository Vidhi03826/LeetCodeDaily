class Solution {
    class tuple{
        int distance, row, col;
        tuple(int distance, int row, int col){
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m =heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = (int)(1e9);
            }
        }

        dist[0][0] = 0;
         int[] delr = {-1,0,1,0};
         int[] delc = {0,1,0,-1};

         PriorityQueue<tuple> pq = new PriorityQueue<tuple>((x,y) -> x.distance - y.distance);
         pq.add(new tuple(0,0,0));

         while(pq.size()!=0){
            int diff = pq.peek().distance;
            int row = pq.peek().row;
            int col = pq.peek().col;
            pq.remove();
        if(row ==m-1 && col == n-1) return diff;
            for(int i =0; i<4;i++){
                int nrow =  row + delr[i] ;
                int ncol = col + delc[i];

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n){
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]) , diff);

                    if(newEffort< dist[nrow][ncol]){
                   dist[nrow][ncol] = newEffort;
                   pq.add(new tuple(newEffort, nrow, ncol));
                    }
                }
            }
         }
         return 0;
     }
}