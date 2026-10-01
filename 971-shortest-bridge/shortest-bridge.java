
import java.util.*;

class Solution {

    int m, n;

    public void dfs(int row, int col, int[][] grid,
                    boolean[][] vis, int[] delrow, int[] delcol) {

        vis[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < m &&
                ncol >= 0 && ncol < n &&
                !vis[nrow][ncol] && grid[nrow][ncol] == 1) {

                dfs(nrow, ncol, grid, vis, delrow, delcol);
            }
        }
    }

    public int bfs(int[][] grid, boolean[][] vis,
                   int[] delrow, int[] delcol) {

        Queue<int[]> q = new LinkedList<>();

        // Add every cell of the first island
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j]) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                int[] curr = q.remove();

                int row = curr[0];
                int col = curr[1];

                for (int i = 0; i < 4; i++) {
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];

                    if (nrow < 0 || nrow >= m ||
                        ncol < 0 || ncol >= n ||
                        vis[nrow][ncol]) {
                        continue;
                    }

                    // Reached the second island
                    if (grid[nrow][ncol] == 1) {
                        return level;
                    }

                    vis[nrow][ncol] = true;
                    q.add(new int[]{nrow, ncol});
                }
            }

            level++;
        }

        return -1;
    }

    public int shortestBridge(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {

                    dfs(i, j, grid, vis, delrow, delcol);

                    return bfs(grid, vis, delrow, delcol);
                }
            }
        }

        return -1;
    }
}
