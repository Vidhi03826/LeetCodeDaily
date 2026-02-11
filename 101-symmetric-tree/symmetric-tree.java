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
    //   boolean isSameTree(TreeNode p, TreeNode q) {
    //     if(p ==null && q ==null) return true;
    //     if(p ==null || q==null) return false;
    //     return (p.val == q.val) && isSameTree(p.left, q.left) &&  isSameTree(p.right, q.right);
    // } 


    //   TreeNode Invert(TreeNode root) {
    //     if(root==null) return false;
    //     TreeNode left = root.left;
    //     TreeNode right = root.right;
    //     root.left = Invert(left);
    //     root.right = Invert(right);

    // }
    public boolean isSymmetric(TreeNode root) {
        // if(root==null) return false;
        // TreeNode left = root.left;
        // TreeNode right = root.right;
        // root.left = isSymmetric(left);
        // root.right = isSymmetric(right);
        return (root==null) ||  SymmtricHelp( root.left , root.right);



    }
    public boolean SymmtricHelp(TreeNode left , TreeNode right) {
    
    if(left==null || right == null){
        return left==right;

    }
    if(left.val!= right.val) return false;
    return SymmtricHelp( left.left ,  right.right) && SymmtricHelp( left.right ,  right.left);


}
}
