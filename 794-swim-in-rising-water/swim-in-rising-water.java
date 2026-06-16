class Solution {

    static class Pair {
        int time;
        int row;
        int col;

        Pair(int time, int row, int col) {
            this.time = time;
            this.row = row;
            this.col = col;
        }
    }

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.time - b.time);

        int[][] dist = new int[n][n];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        dist[0][0] = grid[0][0];

        pq.offer(new Pair(grid[0][0], 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int time = curr.time;
            int r = curr.row;
            int c = curr.col;

            if (r == n - 1 && c == n - 1)
                return time;

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n) {

                    int newTime =
                            Math.max(time, grid[nr][nc]);

                    if (newTime < dist[nr][nc]) {

                        dist[nr][nc] = newTime;

                        pq.offer(
                            new Pair(newTime, nr, nc)
                        );
                    }
                }
            }
        }

        return -1;
    }
}