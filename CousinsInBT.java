/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int xLevel, yLevel;
    TreeNode xParent, yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)  return false;

        dfs(root, x, y, 0, null);

        return xParent != yParent && xLevel == yLevel;
    }

    private void dfs(TreeNode node, int x, int y, int level, TreeNode parent) {
        if (node == null) {
            return;
        }

        if (node.val == x) {
            xLevel = level;
            xParent = parent;
        }

        if (node.val == y) {
            yLevel = level;
            yParent = parent;
        }

        if(xParent != null && yParent != null) {
            return;
        }

        dfs(node.left, x, y, level + 1, node);
        dfs(node.right, x, y, level + 1, node);
    }
}