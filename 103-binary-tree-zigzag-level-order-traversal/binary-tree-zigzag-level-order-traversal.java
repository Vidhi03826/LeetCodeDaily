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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        boolean LtoR = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        if(root==null) return res;
        while(!q.isEmpty()){
              int size = q.size();
              List<Integer> row = new ArrayList<>(Collections.nCopies(size, 0));
              for(int i=0;i<size;i++){
                TreeNode node = q.peek();
                q.remove();
              int idx = LtoR ? i : size-i-1;
              row.set(idx ,node.val);
              if(node.left!=null){
                q.add(node.left);
              }
              if(node.right!=null){
                q.add(node.right);
              }
              
              }
            LtoR = !LtoR;
           res.add(row);
    

        }
        return res;
    }
}