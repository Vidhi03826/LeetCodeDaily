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
    int postidx;
    HashMap<Integer, Integer> mpp = new HashMap<>();
    public TreeNode helper(int[] inorder, int[] postorder, int left , int right){
        if(left>right){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postidx--]);

        int inidx = mpp.get(root.val);
      
        root.right =  helper(inorder, postorder, inidx+1 , right);
        root.left =  helper(inorder, postorder, left , inidx-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         postidx = postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            mpp.put(inorder[i], i);
        }
     return helper(inorder, postorder, 0 , inorder.length-1);

    }
}