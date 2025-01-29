/**
 * # Time complexity: O(n), where n is the number of nodes in the tree, as each node is visited once.
 * # Space complexity: O(h), where h is the height of the tree, due to the recursive call stack.
 * # Leetcode: Yes
 */
class Solution {

    // Global variables to store parent and level of x and y
    TreeNode parent_x, parent_y;
    int x_lvl, y_lvl;

    public boolean isCousins(TreeNode root, int x, int y) {
        // Base
        if (root == null) {
            return false;
        }
        // Logic

        // Initialize variables
        parent_x = parent_y = null;
        x_lvl = y_lvl = -1;

        // To calculate parent and level
        dfs(root, null, 0, x, y);

        // Both parents must be different and should be at the same level to be cousins
        return (parent_x != parent_y) && (x_lvl == y_lvl);
    }

    private void dfs(TreeNode root, TreeNode parent, int lvl, int x, int y) {
        // Base
        if (root == null) {
            return;
        }
        // Logic
        if (root.val == x) {
            x_lvl = lvl;
            parent_x = parent;
        }

        if (root.val == y) {
            y_lvl = lvl;
            parent_y = parent;
        }

        dfs(root.left, root, lvl + 1, x, y);
        dfs(root.right, root, lvl + 1, x, y);
    }
}
