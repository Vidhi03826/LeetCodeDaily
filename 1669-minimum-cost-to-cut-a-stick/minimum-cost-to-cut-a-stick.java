class Solution {
    public int helper(int i, int j, int [] cuts, int [][]dp){
   if(i>j) return 0;
   if(dp[i][j] !=-1) return dp[i][j];
   int mini = Integer.MAX_VALUE;
   for(int k =i;k<=j;k++){
    int cost = cuts[j+1] - cuts[i-1] +helper(i,k-1, cuts, dp) + helper(k+1,j, cuts, dp);
    mini = Math.min(cost, mini);
   }

   return dp[i][j]= mini;
    }
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int newcuts[] = new int[c+2];
        for(int i=0;i<c;i++){
            newcuts[i+1]= cuts[i];
        }
      
        newcuts[0] = 0;
        newcuts[c+1] = n;

     Arrays.sort(newcuts);

        int [][] dp = new int[c+2][c+2];

        for(int [] row:dp){
            Arrays.fill(row, -1);
        }


    return helper(1,c, newcuts, dp);

    }
}