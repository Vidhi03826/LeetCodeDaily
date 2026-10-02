class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        int total = 0;

        for (List<Integer> row : nums) {
            total += row.size();
        }

        int[] res = new int[total];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});

        int idx = 0;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            res[idx++] = nums.get(row).get(col);

            // Add first element of next row
            if (col == 0 && row + 1 < nums.size()) {
                q.offer(new int[]{row + 1, 0});
            }

            // Add next element in the same row
            if (col + 1 < nums.get(row).size()) {
                q.offer(new int[]{row, col + 1});
            }
        }

        return res;
    }
}