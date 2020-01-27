/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * 
 * Time Complexity : O(n)
 * Space Complexity : O(H) where H is the height of the tree
 * 
 */
class Solution {
    
    TreeNode x_parent = null;
    TreeNode y_parent = null;
    
    int x_depth = -1;
    int y_depth = -2;
    
    public boolean isCousins(TreeNode root, int x, int y) {
    
        if(root == null){
            return false;
        }
        
        helper(root, x, y, 0, null);
        
        return x_depth == y_depth && x_parent != y_parent;
    }
    
    private void helper(TreeNode root, int x, int y, int depth, TreeNode parent){
        
        //Base Case
        if(root == null){
            return;
        }
        
        //Logic
        if(root.val == x){
            x_parent = parent;
            x_depth = depth;
        }
        
        if(root.val == y){
            y_parent = parent;
            y_depth = depth;
        }
        
        helper(root.left, x, y, depth+1, root);
        helper(root.right, x, y, depth+1, root);
    }
}