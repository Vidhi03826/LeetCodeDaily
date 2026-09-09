class Solution {
    public int findSpecialInteger(int[] arr) {
        
        int n = arr.length;

        int[] candidates = {
            arr[n / 4],
            arr[n / 2],
            arr[(3 * n) / 4]
        };

        for (int num : candidates) {

            int leftidx = lowerbound(arr, num);
            int rightidx = upperbound(arr, num);

            if (rightidx - leftidx + 1 > n / 4) {
                return num;
            }
        }

        return -1;
    }

    private int lowerbound(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ans = mid;
                right = mid - 1;
            }
            else if (arr[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return ans;
    }


    private int upperbound(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ans = mid;
                left = mid + 1;
            }
            else if (arr[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return ans;
    }
}