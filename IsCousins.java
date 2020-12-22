// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

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
    
    int x_level, y_level;
    TreeNode x_parent, y_parent;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null) return true;
        dfs(root, null, 0, x, y);
        return x_level == y_level && x_parent != y_parent;
        
    }
    
    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y) {
        if(root == null) {
            return;
        }
        
        if(root.val == x) {
            x_level = level;
            x_parent = parent;
        }
        if(root.val == y) {
            y_level = level;
            y_parent = parent;
        }
        dfs(root.left, root, level + 1, x, y);
        dfs(root.right, root, level + 1, x, y);
    }
}