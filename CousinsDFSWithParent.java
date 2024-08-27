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
class CousinsDFSWithParent {
    TreeNode x_parent = null;
    TreeNode y_parent = null;
    int x_depth = -1;
    int y_depth = -1;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,0,  null, x,y);
        if(x_depth == y_depth && x_parent!= y_parent) {
            return true;
        }
        return false;
    }
    
    private void helper(TreeNode root, int depth, TreeNode parent, int x , int y ) {
        if(root==null) {
            return;
        }
        if(root.val == x) {
            x_parent = parent;
            x_depth = depth;
        }
        if(root.val == y) {
            y_parent = parent;
            y_depth = depth;
        }
        
        helper(root.left, depth+1, root, x, y );
        helper(root.right, depth+1, root, x, y );
        return;
    }
}