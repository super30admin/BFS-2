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
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> bfs = new LinkedList<>();
        Queue<TreeNode> parent = new LinkedList<>();

        bfs.add(root);
        parent.add(null);

        while(!bfs.isEmpty()){
            int size = bfs.size();
            boolean flagX = false; 
            boolean flagY = false; 
            TreeNode xParent = null;
            TreeNode yParent = null;

            for(int i=0;i<size;i++){
                TreeNode node = bfs.poll();
                TreeNode par = parent.poll();

                if(node.val==x){
                    flagX = true;
                    xParent = par;
                }
                if(node.val==y){
                    flagY = true;
                    yParent = par;
                }
                if(node.left!=null){
                    bfs.add(node.left);
                    parent.add(node);
                }
                if(node.right!=null){
                    bfs.add(node.right);
                    parent.add(node);
                }
            }

            if(flagX && flagY){
                return xParent.val != yParent.val;
            }
            if(flagX || flagY){
                return false;
            }
        }

        return false;
        
    }
}