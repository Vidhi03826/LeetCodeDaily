class Solution {
    public int getWinner(int[] arr, int k) {
        int winner = arr[0];
        int streak = 0;

        for(int i=1;i<arr.length;i++){
            if(winner<arr[i]){
                winner = arr[i];
                streak = 1;

            }
            else{
                streak++;
            }

            if(streak==k){
                return winner;
            }
        }
        return winner;
    }
}