class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
       Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=8;i++){
            q.add(i);
        }

        while(!q.isEmpty()){
            int temp = q.remove();
            if(temp>=low && temp<=high){
                res.add(temp);
            }
            int lastdigit = temp%10;
            if(lastdigit+1<=9){
                q.add(temp*10 + (lastdigit +1));
            }
        }
        return res;


    }
}