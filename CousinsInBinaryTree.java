/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || x == y)
            return false;

        // DFS Approach
        dfs(root, 0, null, x, y);

        return x_depth == y_depth && x_parent != y_parent; // for x&y to be cousins

    }

    private void dfs(TreeNode root, int lvl, TreeNode parent, int x, int y) {
        // base
        if (root == null)
            return;

        // logic

        if (root.val == x) { // if current node=x
            x_depth = lvl;
            x_parent = parent;
        }
        if (root.val == y) { // if current node=y
            y_depth = lvl;
            y_parent = parent;
        }

        dfs(root.left, lvl + 1, root, x, y);
        dfs(root.right, lvl + 1, root, x, y);

    }
}