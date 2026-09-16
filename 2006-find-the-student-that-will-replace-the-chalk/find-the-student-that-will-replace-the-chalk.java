class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int totSum = 0;
        for(int i=0;i<n;i++){
            totSum +=chalk[i];

            if(totSum>k){
                break;
            }
        }

        int rem = k % totSum;

        for(int i=0;i<n;i++){
            if(rem<chalk[i]){
                return i;
            }

           rem-= chalk[i];
        }
        return -1;
    }
}