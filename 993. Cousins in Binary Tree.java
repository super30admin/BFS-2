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

        Queue<TreeNode[]> q = new LinkedList<>();
        q.offer(new TreeNode[]{root, null});

        while(!q.isEmpty()){
            int size = q.size();
            TreeNode parent = null;
            while(size-- > 0){
                TreeNode[] node = q.poll();
                if(node[0].val == x || node[0].val == y){
                    if(parent != null){
                        return node[1] != parent;
                    } else parent = node[1];
                }
                if(node[0].left != null) q.offer(new TreeNode[]{node[0].left, node[0]});
                if(node[0].right != null) q.offer(new TreeNode[]{node[0].right, node[0]});
            }
            if(parent != null) return false;
        }

        return false;
        
    }
}
