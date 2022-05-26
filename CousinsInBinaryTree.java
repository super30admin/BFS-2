// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

import javax.swing.tree.TreeNode;

public class CousinsInBinaryTree {
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        //null
        dfs(root, x, y, null, 0);
        return x_depth == y_depth && x_parent != y_parent;
    }
    private void dfs(TreeNode root, int x, int y, TreeNode parent, int depth) {
        //base
        if(root == null) return;
        //logic
        if(root.val == x) {
            x_depth = depth;
            x_parent = parent;
        }
        if(root.val == y) {
            y_depth = depth;
            y_parent = parent;
        }
        dfs(root.left, x, y, root, depth + 1);
        dfs(root.right, x, y, root, depth + 1);
    }
}
