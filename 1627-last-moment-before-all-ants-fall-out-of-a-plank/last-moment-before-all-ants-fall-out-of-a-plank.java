class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int res = 0;
        for(int leftidx : left){
         res = Math.max (res , leftidx);
        }

        for(int rightidx : right){
            res = Math.max(res, n - rightidx);
        }
        return res ; 
    }
}