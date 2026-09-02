import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        // litterIndex[i][j] tells which bit belongs to this L
        int[][] litterIndex = new int[m][n];

        int startRow = 0;
        int startCol = 0;
        int count = 0;

        // Find S and assign every L an index
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char cell = classroom[i].charAt(j);

                if (cell == 'S') {
                    startRow = i;
                    startCol = j;
                }

                else if (cell == 'L') {
                    litterIndex[i][j] = count;
                    count++;
                }
            }
        }

        if (count == 0) {
            return 0;
        }

        /*
         * visited[row][col][remainingEnergy][mask]
         *
         * mask contains the litter that is STILL left.
         */
        boolean[][][][] visited =
                new boolean[m][n][energy + 1][1 << count];

        Queue<int[]> queue = new LinkedList<>();

        int startMask = (1 << count) - 1;

        queue.offer(new int[]{
                startRow,
                startCol,
                energy,
                startMask
        });

        visited[startRow][startCol][energy][startMask] = true;

        int[] directions = {-1, 0, 1, 0, -1};

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process all states at the current distance
            for (int s = 0; s < size; s++) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];
                int currentEnergy = current[2];
                int mask = current[3];

                // All litter collected
                if (mask == 0) {
                    return moves;
                }

                // Cannot make another move
                if (currentEnergy == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {

                    int newRow = row + directions[d];
                    int newCol = col + directions[d + 1];

                    // Out of bounds
                    if (newRow < 0 || newRow >= m ||
                        newCol < 0 || newCol >= n) {
                        continue;
                    }

                    char cell =
                            classroom[newRow].charAt(newCol);

                    // Obstacle
                    if (cell == 'X') {
                        continue;
                    }

                    // Every move costs 1 energy
                    int newEnergy = currentEnergy - 1;

                    // Reset energy
                    if (cell == 'R') {
                        newEnergy = energy;
                    }

                    int newMask = mask;

                    // Collect litter
                    if (cell == 'L') {

                        int index =
                                litterIndex[newRow][newCol];

                        newMask &= ~(1 << index);
                    }

                    if (!visited[newRow][newCol]
                                [newEnergy][newMask]) {

                        visited[newRow][newCol]
                               [newEnergy][newMask] = true;

                        queue.offer(new int[]{
                                newRow,
                                newCol,
                                newEnergy,
                                newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}