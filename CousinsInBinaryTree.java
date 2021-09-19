package BFS2;
// Time Complexity : O(n)
// Space Complexity : O(h) (recursion stack)
// Did this code successfully run on Leetcode : yes

import Trees1.TreeNode;

public class CousinsInBinaryTree {
    TreeNode x_par = null;
    TreeNode y_par = null;
    int x_level = -1, y_level = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, null, x, y);
        return x_level == y_level && x_par != y_par;
    }
    private void dfs(TreeNode root, int level, TreeNode par, int x, int y) {
        if (root == null)
            return;
        if (root.val == x) {
            x_par = par;
            x_level = level;
        }
        if (root.val == y) {
            y_par = par;
            y_level = level;
        }
        if (x_level > 0 && y_level > 0)
            return;
        dfs(root.left, level + 1, root, x, y);
        dfs(root.right, level + 1, root, x, y);
    }
}
