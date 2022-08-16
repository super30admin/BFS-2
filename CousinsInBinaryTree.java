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
        TreeNode x_parent;
        TreeNode y_parent;
        int x_found;
        int y_found;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        dfs(root,x,y,0,null);
        return x_found==y_found && x_parent!=y_parent; //check- 1.no same parent 2.both x,y are found
    }
    public void dfs(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root==null) return;
        if(root.val==x) { //if x is found at the root val
            x_found=depth; //assign the level/depth at which x is found
            x_parent=parent; //assign the parent value to check that x & y don't share the same parent
        }
        if(root.val==y) { //if y is found at the root val
            y_found=depth; //assign the level/depth at which y is found
            y_parent=parent; //assign the parent value to check that x & y don't share the same parent
        }
        if(x_parent==null || y_parent==null )
            dfs(root.left,x,y,depth+1,root); //search left
        if(x_parent==null || y_parent==null )
            dfs(root.right,x,y,depth+1,root); // search right
    }
}