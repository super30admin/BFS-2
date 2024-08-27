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
class CousinsDFSWithoutParent {
    boolean flag = true;
    int x_depth = -1;
    int y_depth = -1;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,0, x,y);
        if(flag && x_depth == y_depth) {
            return true;
        }
        return false;
    }
    
    private void helper(TreeNode root, int depth, int x , int y ) {
        if(root==null) {
            return;
        }
        if(root.val == x) {
            x_depth = depth;
        }
        if(root.val == y) {
            y_depth = depth;
        }
        if(root.left!=null && root.right!=null) {
            if(root.left.val ==x  && root.right.val == y) {
                flag = false;
                return;
            }
            if(root.left.val ==y  && root.right.val == x) {
                flag = false;
                return;
            }
        }        
        if(flag) {
            helper(root.left, depth+1, x, y );
            helper(root.right, depth+1, x, y );            
        }

        return;
    }
}