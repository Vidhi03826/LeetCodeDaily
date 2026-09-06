class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefN = new int[n+1];
        int[] suffY = new int[n+1];
        prefN[0] = 0;
        suffY[n] = 0;

        for(int i = 1;i<=n;i++){
            if(customers.charAt(i-1)=='N'){
            prefN[i] = prefN[i-1]+1;
            }
            else{
                prefN[i] = prefN[i-1];
            }
        }

        for(int i=n-1;i>=0;i--){
            if(customers.charAt(i)=='Y'){
                suffY[i] = suffY[i+1] +1;
            }
            else{
                suffY[i] = suffY[i+1];
            }
        }

        int minH = Integer.MAX_VALUE;
        int minPen = Integer.MAX_VALUE;

        for(int i=0;i<=n;i++){
            int Penalty = suffY[i] + prefN[i];
            if(Penalty<minPen){
                minPen = Penalty;
                minH = i;
            }
        }
        return minH;
    }
}