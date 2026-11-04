class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int[] dp = new int[n];

        dp[0] = 1;
        int count = 0;

        for(int j=1;j<n;j++){
            if(j-minJump>=0){
                count+=dp[j-minJump];
            }

            if(j-maxJump-1>=0){
                count-=dp[j-maxJump-1];
            }

            if(count>0 && s.charAt(j)=='0'){
                dp[j]=1;
            }
        }
        return dp[n-1]>0;
    }
}