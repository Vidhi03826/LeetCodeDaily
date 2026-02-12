class Solution {
    public int helper(int i, int j, String s, String t, int [][] dp ){
      int m = s.length();
        int n = t.length();
        
        if(j==0) return 1;
        if(i==0) return 0;
       
        if(dp[i][j] !=-1) return dp[i][j];
       
    
        if(s.charAt(i-1)== t.charAt(j-1)) {
            int take =  helper( i-1,  j-1,  s,  t, dp);
            int notTake = helper( i-1,  j,  s,  t, dp);
            return dp[i][j] =  take + notTake;
        }
        else{// if string notmtched
           return dp[i][j]  = helper( i-1,  j,  s,  t, dp);
        }
       
    }
    public int numDistinct(String s, String t) {
       int[][] dp = new int[s.length()+1][t.length()+1];
        for (int[] row : dp) Arrays.fill(row, -1);

        // Start recursion
        return helper(s.length(), t.length(), s, t, dp);
    }
}