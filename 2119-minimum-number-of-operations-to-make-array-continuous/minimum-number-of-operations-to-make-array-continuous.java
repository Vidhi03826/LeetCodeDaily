class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int operations = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        //now sort
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            int L = list.get(i);
            int R = L + n;

            int low = 0;
            int high = list.size()-1;
            while(low<=high){
                int mid = high + (low -high)/2;
                if(list.get(mid)<R){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
         int inrange = low - i;
         int outrange = n - inrange;
         operations = Math.min(operations , outrange);
        }

        return operations;
        
    }
}