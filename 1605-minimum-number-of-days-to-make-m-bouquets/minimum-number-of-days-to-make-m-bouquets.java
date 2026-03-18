class Solution {

    public boolean ispossible(int[] bloomDay, int val, int m, int k){
        int n = bloomDay.length;
        int count = 0;
        int bouquet = 0;

        for(int i = 0; i < n; i++){
            if(bloomDay[i] <= val){
                count++;
            } else {
                bouquet += (count / k);
                count = 0;
            }
        }

        bouquet += (count / k);
        return bouquet >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        long totalNeeded = (long)m * k;
        int n = bloomDay.length;

        if(n < totalNeeded){
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        int low = min;
        int high = max;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(ispossible(bloomDay, mid, m, k)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}