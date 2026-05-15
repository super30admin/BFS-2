// https://leetcode.com/problems/cousins-in-binary-tree/
// Time Complexity : O(n) where n is the number of nodes in the tree.
// Space Complexity : O(h) where h is the height of the tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    TreeNode x_parent, y_parent;
    int x_level, y_level;

    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, x, y, 0, null);
        return x_level == y_level && x_parent != y_parent;
    }

    private void helper(TreeNode root, int x, int y, int level, TreeNode parent) {
        if (root == null)
            return;

        if (root.val == x) {
            x_level = level;
            x_parent = parent;
        }

        if (root.val == y) {
            y_level = level;
            y_parent = parent;
        }
        if (x_parent == null || y_parent == null) {

            helper(root.left, x, y, level + 1, root);
        }
        if (x_parent == null || y_parent == null) {
            helper(root.right, x, y, level + 1, root);
        }
    }
}