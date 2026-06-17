/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void markParent(TreeNode root, Map<TreeNode, TreeNode> parentTrack){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();

            if(curr.left!=null){
                parentTrack.put(curr.left, curr);
                q.add(curr.left);
            }
            if(curr.right!=null){
                parentTrack.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        markParent(root, parentTrack);

        Map<TreeNode, Boolean> vis = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        vis.put(target, true);
        int currLevel = 0;


        while(!q.isEmpty()){
            int size = q.size();
            if(currLevel==k)break;
            currLevel++;

            for(int i=0;i<size;i++){
                TreeNode curr = q.remove();
                if(curr.left!=null && vis.get(curr.left)==null){
                    vis.put(curr.left, true);
                    q.add(curr.left);
                }
                if(curr.right!=null && vis.get(curr.right)==null){
                    vis.put(curr.right, true);
                    q.add(curr.right);
                }
                if(parentTrack.get(curr)!=null && vis.get(parentTrack.get(curr))==null){
                    vis.put(parentTrack.get(curr), true);
                    q.add(parentTrack.get(curr));
            }
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            res.add(curr.val);
        }
        return res;
    }
}