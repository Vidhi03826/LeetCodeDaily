class Solution {
    public int helper(int[] weights, int cap){
        int load = 0;
        int days = 1;

        for(int i=0;i<weights.length;i++){
            if(load+weights[i]> cap){
                days++;
                load = weights[i];
            }
            else{
                load+=weights[i];
            }

        }
        return days;

    }
    public int shipWithinDays(int[] weights, int d) {
        int low  = Integer.MIN_VALUE;
        int high = 0;
        for(int i=0;i<weights.length;i++){
            low = Math.max(low, weights[i]);
            high +=weights[i];
        }

        while(low<=high){
            int mid = (low+high)/2;
            int totaldays  = helper(weights, mid);
            if(totaldays<=d){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;

    }
}