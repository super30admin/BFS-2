// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * find x and y, their level and parents, if level same and parent different return true
 *https://leetcode.com/problems/cousins-in-binary-tree/
 *
 */
public class CousinInBinaryTree {
	TreeNode x_parent, y_parent;
    int x_level, y_level;
    boolean x_found, y_found;
    
    boolean res;
    
    public boolean isCousins(TreeNode root, int x, int y) {
       
        helper(root, x, y, 0, null);
        return res;
    }
    
    //find x and y recursively and maintain their levels and 
    private void helper(TreeNode root, int x, int y, int level, TreeNode parent) {
        
        if(root == null) return;
        
        if(root.val == x) {
            x_parent =  parent;
            x_level = level;
            x_found = true;
        }else if(root.val == y) {
            y_parent =  parent;
            y_level = level;
            y_found = true;
        }
        
        //if x and y found at same level and different parent , set res = true
        if(x_found && y_found && x_level == y_level && x_parent.val != y_parent.val){
           res = true; 
        }
        
        //call helper for left and right and increase level by 1, pass current root as parent
        if(root.left != null){
            helper(root.left, x, y, level+1, root);
        }
        
        if(root.right != null){
            helper(root.right, x, y, level+1, root);
        }
    }
}
