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
    public boolean helper(long minval, long maxval, TreeNode root){
        
    
        if(root==null) return true;
        if(root.val<=minval || root.val>=maxval) return false;

        return helper(minval, root.val, root.left) && helper(root.val, maxval, root.right);

    }
    public boolean isValidBST(TreeNode root) {
        long minval = Long.MIN_VALUE;
        long maxval = Long.MAX_VALUE;
        return helper(minval, maxval, root);
    }
}