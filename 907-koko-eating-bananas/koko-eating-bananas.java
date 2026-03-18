class Solution {
    public int findmax(int[] piles){
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            maxi = Math.max(maxi, piles[i]);
        }
        return maxi;
    }
    public int helper(int[] piles, int h){
        int totalhours = 0;
        for(int i=0;i<piles.length;i++){
            totalhours+=Math.ceil((double)piles[i]/(double)(h));
        }
        return totalhours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findmax(piles);
       
        while(low<=high){
            int mid = (low+high)/2;
          long  totalhours = helper(piles, mid);
            if(totalhours<=h){
              
                high = mid -1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}