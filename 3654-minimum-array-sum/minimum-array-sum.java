class Solution {
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        int memo[][][] = new int[nums.length][op1+1][op2+1];
        for(int[][] mat : memo){
            for(int[] row : mat){
                Arrays.fill(row , -1);
            }
        }
        return solve(nums , k , op1 , op2 , 0,memo);
    }
    public int solve(int[] nums, int k, int op1, int op2 , int i,int [][][] memo){
        //base case
       if(i==nums.length){
        return 0;
       }

       if(memo[i][op1][op2]!=-1){
        return memo[i][op1][op2];
       }
        int result = Integer.MAX_VALUE;
    //Apply op1
    if(op1>0){
       int newVal = (nums[i] + 1) / 2;
        int applyop1 = newVal + solve(nums , k , op1-1 , op2 , i+1,memo);
        result = Math.min(result , applyop1);
    }

    //Applyop2
    if(op2>0 && nums[i]>=k){
        
        int newVal = nums[i]-k;
        
       
        int applyop2 = newVal + solve(nums , k , op1 , op2-1 , i+1,memo);
        result = Math.min(result , applyop2);
    }

    //applyop1 then op2
    if(op1>0 && op2>0){
        int newVal = (nums[i] + 1) / 2;
        if(newVal>=k){
         newVal = newVal-k;
        

        int applyop1op2 = newVal + solve(nums , k , op1-1 , op2-1 , i+1,memo);
        result = Math.min(result , applyop1op2);
        }

    }

    //applyop2op1
    if(op1>0 && op2>0 && nums[i]>=k){
        
         int newVal = nums[i]-k;
        
         newVal = (newVal + 1) / 2;
        

        int applyop2op1 = newVal + solve(nums , k , op1-1 , op2-1 , i+1,memo);
        result = Math.min(result , applyop2op1);

    }

    //no operation

    result = Math.min(result, nums[i] + solve(nums, k, op1, op2, i+1 ,memo ));
    return memo[i][op1][op2] = result;

    }
}