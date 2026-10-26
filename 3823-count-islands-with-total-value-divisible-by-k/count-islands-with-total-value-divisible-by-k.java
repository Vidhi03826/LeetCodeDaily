class Solution {
    int m, n;
    int k;
    int[][] grid;
    boolean[][] visited;

    public int countIslands(int[][] grid, int k) {
        this.grid = grid;
        this.k = k;

        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] != 0 && !visited[i][j]) {

                    long sum = dfs(i, j);

                    if (sum % k == 0) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    public long dfs(int i, int j) {

        if (i < 0 || i >= m || j < 0 || j >= n
                || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        long sum = grid[i][j];

        sum += dfs(i + 1, j);
        sum += dfs(i - 1, j);
        sum += dfs(i, j + 1);
        sum += dfs(i, j - 1);

        return sum;
    }
}