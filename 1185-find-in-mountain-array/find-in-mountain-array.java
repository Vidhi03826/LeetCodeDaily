class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int n = mountainArr.length();

        // Find Peak
        int left = 0;
        int right = n - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1))
                left = mid + 1;
            else
                right = mid;
        }

        int peak = left;

        // Search Left
        int ans = binarySearch(mountainArr, target, 0, peak, true);

        if (ans != -1)
            return ans;

        // Search Right
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }

    private int binarySearch(MountainArray arr,
                             int target,
                             int left,
                             int right,
                             boolean asc) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int value = arr.get(mid);

            if (value == target)
                return mid;

            if (asc) {

                if (value < target)
                    left = mid + 1;
                else
                    right = mid - 1;

            } else {

                if (value < target)
                    right = mid - 1;
                else
                    left = mid + 1;

            }
        }

        return -1;
    }
}