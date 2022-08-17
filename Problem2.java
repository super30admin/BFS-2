/ Time Complexity : O(n)
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
    int x_depth;
    int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null) return false;
        dfs(root, x, y, 0, null);
        return x_depth == y_depth && x_parent != y_parent;
    }
    
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        // base
        if(root == null) return;
        
        // logic
        if(root.val == x) {
            x_parent = parent;
            x_depth = depth;
        }
        if(root.val == y) {
            y_parent = parent;
            y_depth = depth;
        }
        
        dfs(root.left, x, y, depth + 1, root);
        dfs(root.right, x, y, depth + 1, root);
    }
}