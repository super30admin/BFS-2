// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    int x_height;
    int y_height;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, x, y, 0, null);
        return (x_parent != y_parent && x_height == y_height);
    }
        
    private void dfs(TreeNode root, int x, int y, int height, TreeNode parent){
        // base
        if(root == null) return;
        
        // logic
        if(root.val == x){
            x_parent = parent;
            x_height = height;
        }
        
        if(root.val == y){
            y_parent = parent;
            y_height = height;
        }
        
        dfs(root.left, x, y, height + 1,root);
        dfs(root.right, x, y, height + 1,root);

    }
        
}