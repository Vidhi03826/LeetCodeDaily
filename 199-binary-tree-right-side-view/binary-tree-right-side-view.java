/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void helper(TreeNode curr, List<Integer> res, int currdepth){
       if(curr==null) return;
       if(currdepth==res.size()){
        res.add(curr.val);
       }
        helper(curr.right,res, currdepth+1);
        helper(curr.left,res, currdepth+1);

    }
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer> res = new ArrayList<Integer>();
        
          helper(root, res, 0);
          return res;

    }
}