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
       int maxDepth(TreeNode root) {
        if(root ==null) return 0;
        return 1 + Math.max(maxDepth( root.left),  maxDepth(root.right));
    }
    public boolean isBalanced(TreeNode root) {
     if (root ==null) return true;
       int rightHeight = maxDepth(root.right);
       int leftHeight = maxDepth(root.left);
       int d = rightHeight - leftHeight;

        if(d<0) d = -d;
        if(d>1) {
            return false;
            }
            return isBalanced(root.left) && isBalanced( root.right);
    }
}