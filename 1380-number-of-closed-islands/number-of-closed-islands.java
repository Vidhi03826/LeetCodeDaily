import java.util.*;

class Solution {

    public int closedIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        // Step 1: Mark all boundary-connected 0s as visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if ((i == 0 || j == 0 ||
                     i == m - 1 || j == n - 1)
                     && grid[i][j] == 0
                     && !visited[i][j]) {

                    bfs(grid, visited, i, j);
                }
            }
        }

        // Step 2: Count remaining closed islands
        int count = 0;

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {

                if (grid[i][j] == 0 && !visited[i][j]) {

                    bfs(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }


    private void bfs(int[][] grid, boolean[][] visited, int r, int c) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{r, c});
        visited[r][c] = true;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int row = curr[0];
            int col = curr[1];

            for (int i = 0; i < 4; i++) {

                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < m &&
                    ncol >= 0 && ncol < n &&
                    grid[nrow][ncol] == 0 &&
                    !visited[nrow][ncol]) {

                    visited[nrow][ncol] = true;
                    queue.offer(new int[]{nrow, ncol});
                }
            }
        }
    }
}