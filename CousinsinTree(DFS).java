//Time Complexity : O(n), where n is the number of nodes in the tree.
//Space Complexity : O(h), stack space where h is the max height of the tree.
//Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
    int x_depth;
    int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root , 0 , null , x , y);
        return x_parent != y_parent && x_depth == y_depth;
    }
    private void dfs(TreeNode root, int depth,TreeNode parent, int x, int y){
        if(root == null)return;
        
        if(root.val == x){
            x_parent = parent;
            x_depth = depth; 
            
        }
        if(root.val == y){
            y_depth = depth;
            y_parent = parent;
        }
        
        dfs(root.left,depth + 1,root, x , y);
        dfs(root.right,depth + 1,root, x , y);
    }
}