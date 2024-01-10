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

/*
 * DFS approach
 * each level, if we find x or y, we update their corresponding nodes, and we
 * also update the level.
 * TC & SC: O(n)
 */
class Solution {

    int x_level, y_level;
    TreeNode x_parent, y_parent;

    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null || x == y)
            return false;

        x_level = 0;
        y_level = 0;

        dfs(root, x, y, null, 0);
        return x_level == y_level && x_parent != y_parent;
    }

    private void dfs(TreeNode root, int x, int y, TreeNode parent, int level) {
        // base case
        if (root == null)
            return;

        // logic
        // in-order wont work here. we have to check frst; following codition has to be
        // in Pre-order fashion

        if (x_parent == null || y_parent == null)
            dfs(root.left, x, y, root, level + 1);

        if (x_parent == null || y_parent == null)
            dfs(root.right, x, y, root, level + 1);
        if (root.val == x) {
            x_parent = parent;
            x_level = level;
        }
        if (root.val == y) {
            y_parent = parent;
            y_level = level;
        }
    }
}