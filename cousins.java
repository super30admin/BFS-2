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

// Time Complexity : O(n)
// Space Complexity : O(h) recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    TreeNode x_parent, y_parent; // global variable for parents
    int x_lvl, y_lvl; // global variables for levels
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        dfs(root, 0, null, x, y); // recursive call
        return (x_parent != y_parent) && (x_lvl == y_lvl);
    }

    private void dfs(TreeNode root, int level, TreeNode parent, int x, int y){
        if(root == null){
            return;
        }
        if(root.val == x){ // check if equal to x
            x_parent = parent;
            x_lvl = level;
        }
        if(root.val == y){ // check if equal to y
            y_parent = parent;
            y_lvl = level;
        }
        
        dfs(root.left, level + 1, root, x, y); // go left
        dfs(root.right, level + 1, root, x, y); // go right

    }
}