class Solution {
     private int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {

        //prcompute count with numbr of zeroes and ones
        int[][] count = new int[strs.length][2];
          dp = new int[strs.length][m + 1][n + 1];

          for(int[][] rows2d : dp){
            for(int[]rows1d : rows2d){
                Arrays.fill(rows1d , -1);
            }
          }

        for(int i=0;i<strs.length;i++){
            int countzeroes = 0;
            int countones = 0;

            for(char ch : strs[i].toCharArray()){
                if(ch=='0'){
                    countzeroes++;
                }
                else{
                    countones++;
                }
            }

            count[i] = new int[]{countzeroes , countones};
        }
        return solve(0 , m , n , count);


    }

    public int solve(int i , int m , int n , int[][] count){
        if(i>=count.length){
            return 0;
        }
        int result = 0;

        if (dp[i][m][n] != -1) {
            return dp[i][m][n];
        }

        int skip = solve(i+1 , m , n ,count);

        int take = 0;

        if(count[i][0]<=m && count[i][1]<=n){
            take = 1 + solve(i+1 , m-count[i][0] , n-count[i][1] , count);
        }

        result = Math.max(skip , take);
        return dp[i][m][n] = result;
    }

}