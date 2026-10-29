class Solution {
    int [] dp;
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        dp = new int[n];
        // Arrays.fill(dp , -1);
        for(int i = n-1 ; i>=0;i--){
            if(i+k<n)
            dp[i] = energy[i] + dp[i+k];

            else
            dp[i] = energy[i];
        }
                int result = dp[0];


        for(int sp = 1;sp<n ; sp++){
                result = Math.max(result , dp[sp]);
            }
            return result;
        }
        
    
    // public int solve(int i , int k  , int[] energy){
    //     int n = energy.length;
    //      if(i>=n){
    //         return 0;
    //     }
    //     if(dp[i]!=-1){
    //         return dp[i];
    //     }
       

    //     return dp[i] = energy[i] + solve(i+k , k ,energy);
    // }
}