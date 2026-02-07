class Solution {
    public int climbStairs(int n ) {
        int [] dp = new int[n+1];
        // Arrays.fill(-1);
       for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return climbHelpers(n , dp);
       
        
                    

    }
    private int climbHelpers(int n, int [] dp){
      if(n==0) return 1;
        if(n==1) return 1;
        if(dp[n] != -1) return dp[n];
       return dp[n] =  climbHelpers(n -1 , dp) + climbHelpers(n-2 , dp);
    }
}