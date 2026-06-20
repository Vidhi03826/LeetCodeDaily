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
    TreeNode prev= null;
    public int minDiffInBST(TreeNode root) {
        
        int ans =  Integer.MAX_VALUE;
        if(root==null){
            return Integer.MAX_VALUE;
        }

        if(root.left!=null){
           int leftMin = minDiffInBST(root.left);
           ans = Math.min(ans, leftMin);
        }

        if(prev!=null){
            ans = Math.min(ans , root.val - prev.val);
         }
         prev = root;

         if(root.right!=null){
           int rightMin = minDiffInBST(root.right);
           ans = Math.min(ans, rightMin);
         }
         return ans;
        
    }
}