// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class BinaryTreeCousinsDFS {
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, null, x, y);
        return x_depth == y_depth && x_parent != y_parent;
    }

    private void dfs(TreeNode root, int depth, TreeNode parent, int x, int y) {
        // base
        if (root == null) return;

        // logic
        if (x == root.val) {
            x_depth = depth;
            x_parent = parent;
        }

        if (y == root.val) {
            y_depth = depth;
            y_parent = parent;
        }

        dfs(root.left, depth + 1, root, x, y);
        dfs(root.right, depth + 1, root, x, y);
    }
}
