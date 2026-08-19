import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        // Store reserved seats row-wise
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.computeIfAbsent(row, k -> new HashSet<>()).add(col);
        }

        // Initially every row can accommodate 2 families
        int ans = (n - map.size()) * 2;

        for (HashSet<Integer> seats : map.values()) {

            // Left family: seats 2,3,4,5
            boolean left = true;
            for (int i = 2; i <= 5; i++) {
                if (seats.contains(i)) {
                    left = false;
                    break;
                }
            }

            // Right family: seats 6,7,8,9
            boolean right = true;
            for (int i = 6; i <= 9; i++) {
                if (seats.contains(i)) {
                    right = false;
                    break;
                }
            }

            // Middle family: seats 4,5,6,7
            boolean middle = true;
            for (int i = 4; i <= 7; i++) {
                if (seats.contains(i)) {
                    middle = false;
                    break;
                }
            }

            if (left && right) {
                ans += 2;
            } else if (left || right || middle) {
                ans += 1;
            }
        }

        return ans;
    }
}