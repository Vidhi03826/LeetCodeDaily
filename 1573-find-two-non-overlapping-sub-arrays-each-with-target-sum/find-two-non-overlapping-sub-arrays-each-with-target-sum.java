class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int  i =0;
         int j = 0;
          int n = arr.length;int currsum = 0;
          int[] minlentillIdx = new int[n];
          int bestmin = Integer.MAX_VALUE;
          int res =  Integer.MAX_VALUE;

          for( i = 0;i<n;i++){
            minlentillIdx[i] = Integer.MAX_VALUE;
          }
          i=0;

          while(j<n){
            currsum+=arr[j];
            while(i<=j && currsum>target){
                currsum-= arr[i];
                i++;
            }

            if(currsum ==target){
                int len = j-i+1;

                if(i>0 && minlentillIdx[i-1]!=Integer.MAX_VALUE){
                   res = Math.min(res , len+ minlentillIdx[i-1]);
                }

                 bestmin = Math.min(bestmin , len);
            }
           minlentillIdx[j] = bestmin;
           j++;
          }

          return res == Integer.MAX_VALUE ? -1 : res;
    }
}