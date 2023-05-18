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
//  bfs

// Time : O(n)
// Space : O(h)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        boolean fx;
        boolean fy;
        int lx;
        int ly;
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return false;
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            level++;
            fx =false;
            fy =false;
            int size = q.size();
            for(int i = 0 ; i< size; i ++){
                TreeNode node  = q.poll();
                if(node.val == x){
                    fx =true;
                }
                if(node.val == y){
                    fy =true;
                }
                if(node.left!= null && node.right!=  null){
                    if(node.left.val == x && node.right.val ==y){
                        return false;
                    }
                    if(node.left.val == y && node.right.val ==x){
                        return false;
                    }
                }
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);

                
            }
            if(fx && fy){
                    return true;
                }
        }

        return false;

    }
}