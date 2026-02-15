class Solution {
    int helper(int ind, int[] arr, int k, int[] dp){
        if(ind == arr.length) return 0;
        if(dp[ind] !=-1) return dp[ind];
        int len =0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;

        for(int j=ind; j< Math.min(arr.length,ind+k); j++){
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = len * maxi + helper(j+1, arr, k, dp);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[ind] = maxAns;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
     
      int n = arr.length;
      int [] dp = new int[n];
      Arrays.fill(dp,-1);

      return helper(0, arr, k ,dp);
     }
}