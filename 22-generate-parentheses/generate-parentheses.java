class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
         solve(0, 0 , "" ,  n  , ans);
         return ans;
    }

    public void solve(int open , int close ,String ls , int n , List<String> ans){
       
       if(ls.length()==  2* n){
        ans.add(ls);
        return ;
       }
        if(open<n){
            solve(open+1 , close , ls + '(' ,n ,  ans);
        }
        if(close<open){
            solve(open , close+1 , ls+ ')' ,n ,  ans);
        }


    }
}