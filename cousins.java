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

 /*
Time Complexity : O(n) where n is number of nodes in tree.
Space Complexity :  O(h) where h is height of the stack

 */
class Solution {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_height;
    int y_height;
    
    
        public boolean isCousins(TreeNode root, int x, int y) {
    
            helper(root,x,y,0,null);
            
            return x_height == y_height && x_parent!=y_parent;
        
    }
    
    public void helper(TreeNode root, int x, int y, int level, TreeNode parent) {
        
        
        // base logic 
        
        if(root == null) return;
        
        
        // logic
        
        if(root.val == x) {
            
            x_parent = parent;
            x_height = level;
        }
        
        if(root.val == y) {
            
            y_parent = parent;
            y_height = level;
        }
        
        helper(root.left,x,y,level +1, root);
        helper(root.right,x,y,level +1, root);
        
        
        
    }
    
    
}