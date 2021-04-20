/*
Thought Process: 
Check if parents are differnt and on same level. Used DFS in this approach where we mark parents of both x and y when found and x and y levels as well.

TC -> O(N) where N is total number of nodes
SC -> O(H) where H is height of the tree
*/

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
class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int x_level = 0, y_level = 0, level = 1;
        TreeNode x_parent = null, y_parent = null;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i< size; i++){
                TreeNode polled = q.poll();
                if(polled.left!=null) {
                    q.add(polled.left);
                    if(polled.left.val == x){
                        x_level = level;
                        x_parent = polled;
                    }
                    if(polled.left.val == y){
                        y_level = level;
                        y_parent = polled;
                    }
                }
                if(polled.right!=null) {
                    q.add(polled.right);
                    if(polled.right.val == x){
                        x_level = level;
                        x_parent = polled;
                    }
                    if(polled.right.val == y){
                        y_level = level;
                        y_parent = polled;
                    }
                }
            }
            level++;
        }
        return ((x_level == y_level) && (x_parent!= y_parent));
    }
}