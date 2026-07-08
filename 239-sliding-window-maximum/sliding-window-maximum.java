class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length - k+1];

        for(int i=0;i<k;i++){
            while(dq.size()>0 && nums[dq.peekLast()] <= nums[i] ){
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        int id = 0;
        res[id++] = nums[dq.peekFirst()];

        for(int i=k;i< nums.length;i++){
            while (!dq.isEmpty() &&
                   dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }


            while(dq.size()>0 && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }

            dq.offerLast(i);
            res[id++] = nums[dq.peekFirst()];
        }
        return res;
    }
}