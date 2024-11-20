// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// DFS

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class cousinsInTree {
    int x_depth = 0, y_depth = 0;
    TreeNode x_parent = null, y_parent = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, null);
        return (x_depth == y_depth && x_parent != y_parent);
    }
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        // base case
        if (root == null) return;
        // logic
        if (root.val == x) {
            x_parent = parent;
            x_depth = depth;
        }
        if (root.val == y) {
            y_parent = parent;
            y_depth = depth;
        }
        dfs(root.left, x, y, depth + 1, root);
        dfs(root.right, x, y, depth + 1, root);
    }
}