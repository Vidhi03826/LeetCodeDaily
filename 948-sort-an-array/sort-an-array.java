class Solution {
    public void mergeSort(int[] nums , int low, int high){
        if(low>=high) return ;
        int mid = low + (high -low)/2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid +1 , high);
        merge(nums, low, high , mid);
    }
    public void merge(int [] nums, int low, int high, int mid){
      int n1 = mid-low + 1;
      int n2 = high - mid;

      int[] l = new int[n1];
      int [] r = new int[n2];

      for(int i=0;i<n1;i++){
        l[i] = nums[low + i];
      }

      for(int j=0;j<n2;j++){
        r[j] = nums[mid + 1 +j];
      }

      int i=0 , j= 0, k = low;

      while(i<n1 && j<n2){
        if(l[i]<=r[j]){
         nums[k++] = l[i++];
        }
        else{
            nums[k++] = r[j++];
        }
      }
      while(i<n1){
        nums[k++] = l[i++];
      }
      while(j<n2){
        nums[k++] = r[j++];
      }

    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0 , nums.length-1);
        return nums;
    }
}