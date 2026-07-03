import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int el1 = 0, el2 = 0;

        // Phase 1: Find candidates
        for (int num : nums) {
            if (el1 == num) {
                count1++;
            } else if (el2 == num) {
                count2++;
            } else if (count1 == 0) {
                el1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                el2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Phase 2: Verify candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == el1) count1++;
            else if (num == el2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        if (count1 > n / 3) result.add(el1);
        if (count2 > n / 3) result.add(el2);

        return result;
    }
}