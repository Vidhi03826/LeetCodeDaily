class Solution {
    private int n;
    private Map<Integer , Integer> mp;
    private long[] dp;
    public long maximumTotalDamage(int[] power) {
        n = power.length;
        mp = new HashMap<>();
        dp = new long[n];
        Arrays.fill(dp , -1);

        for(int i=0;i<n;i++){
            mp.put(power[i] , mp.getOrDefault(power[i] , 0)+1);
        }
        //map to nums to remove duplicates

        List<Integer> nums=  new ArrayList<>(mp.keySet());
        Collections.sort(nums);

        //ab nums ready ab apply main recursin
        return solve(nums , 0);
    }

    public long solve(List<Integer> nums , int i){
        if(i>=nums.size()){
            return 0;
         }

         if(dp[i]!=-1){
            return dp[i];
         }

        long skip = solve(nums, i+1);
        int j = lowerbound(nums , i+1 , nums.get(i) +3);
        long take =(long) mp.get(nums.get(i)) * nums.get(i) + solve(nums , j);

        return dp[i] = Math.max(take , skip);
    }

    public int lowerbound(List<Integer> nums , int i , int target){
        int low =i ;
        int high = nums.size();

        while(low<high){
        int mid = low + (high - low) / 2;
             if(nums.get(mid)>= target){
              
                high = mid;
             }
             else{
                low = mid+1;
             }
            
     }
     return low;
    }
} 