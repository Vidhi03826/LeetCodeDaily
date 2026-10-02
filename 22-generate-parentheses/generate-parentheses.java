class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        solve(0, 0, n, "", ans);

        return ans;
    }

    public void solve(int open, int close, int n,
                      String str, List<String> ans) {

        // If we've used all n pairs
        if (str.length() == 2 * n) {
            ans.add(str);
            return;
        }

        // We can add '(' if we still have some left
        if (open < n) {
            solve(open + 1, close, n, str + "(", ans);
        }

        // We can add ')' only if there is an unmatched '('
        if (close < open) {
            solve(open, close + 1, n, str + ")", ans);
        }
    }
}