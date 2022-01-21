// Time Complexity : O(n)
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : Yes

public class CousinsInBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode x_parent, y_parent;
    int x_height, y_height;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;

        dfs(root, null, 0, x, y);

        return x_parent != y_parent && x_height == y_height;
    }

    private void dfs(TreeNode root, TreeNode parent, int height, int x, int y) {
        //  base
        if (root == null)
            return;

        //  logic
        if (x == root.val) {
            x_parent = parent;
            x_height = height;
        }

        if (y == root.val) {
            y_parent = parent;
            y_height = height;
        }

        dfs(root.left, root, height + 1, x, y);
        dfs(root.right, root, height + 1, x, y);
    }
}
