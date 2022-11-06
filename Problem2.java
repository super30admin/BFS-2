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
// time = O(n)
// space = O(n)
class Solution {

    TreeNode xParent, yParent;
    int xlevel, ylevel;
    int x, y;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;

        dfs(root, 0, null);

        return xParent != null && yParent != null && (xlevel == ylevel && xParent != yParent);

    }

    private void dfs(TreeNode node, int level, TreeNode parent) {

        if (node == null) {
            return;
        }

        if (node.val == x) {
            xParent = parent;
            xlevel = level;
            return;
        }

        if (node.val == y) {
            yParent = parent;
            ylevel = level;
            return;
        }

        if (xParent != null && yParent != null) {
            return;
        }

        dfs(node.right, level + 1, node);
        dfs(node.left, level + 1, node);

    }
}