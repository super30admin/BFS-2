//TC is O(n)
//SC is O(h)

class Solution {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_level, y_level;

    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null || x == 0 || y == 0) {
            return false;
        }

        dfs(root, x, y, 0, null);

        return x_level == y_level && x_parent != y_parent;
    }

    private void dfs(TreeNode root, int x, int y, int level, TreeNode parent) {
        // base
        if (root == null)
            return;

        // logic
        if (root.val == x) {
            x_parent = parent;
            x_level = level;
        }

        if (root.val == y) {
            y_parent = parent;
            y_level = level;
        }

        if (x_parent == null && y_parent == null) {
            dfs(root.left, x, y, level + 1, root);
            dfs(root.right, x, y, level + 1, root);
        }

    }
}