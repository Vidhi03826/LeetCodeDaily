class Solution {
    class Pair{
        int first, second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
      int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }
          int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},  {0, 1},{1, -1}, 
             {1, 0},  {1, 1}
        };


        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0));
        grid[0][0] = 1;

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int dist = grid[row][col];

            q.remove();
          if(row == n-1 && col==n-1){
            return dist;
          }
             for (int[] d : dirs) {
                int nx = row + d[0];
                int ny = col + d[1];

                if (nx >= 0 && ny >= 0 &&
                    nx < n && ny < n &&
                    grid[nx][ny] == 0) {

                    grid[nx][ny] = dist + 1;
                    q.offer(new Pair(nx, ny));
                }
            }
          
        }
        return -1;
    }
}