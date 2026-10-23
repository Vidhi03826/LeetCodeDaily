
import java.util.HashMap;

class Solution {

    public int waysToReachStair(int k) {
        HashMap<String, Integer> map = new HashMap<>();
        return solve(1, 0, 1, k, map);
    }

    public int solve(int i, int jump, int canJump, int k,
                     HashMap<String, Integer> map) {

        if (i > k + 1) {
            return 0;
        }

        String key = i + " " + jump + " " + canJump;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        int ways = 0;

        if (i == k) {
            ways++;
        }

        // Move down by 1
        if (canJump == 1 && i > 0) {
            ways += solve(i - 1, jump, 0, k, map);
        }

        // Move up by 2^jump
        if (jump < 31 && i + (1 << jump) <= k + 1) {
            ways += solve(i + (1 << jump), jump + 1, 1, k, map);
        }

        map.put(key, ways);
        return ways;
    }
}
