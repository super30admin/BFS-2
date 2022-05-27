//Time Complexity: O(n)
//Space Complexity:o(n)
//Did this code successfully run on Leetcode :Yes

class Solution {
    private int xdep;
    private int ydep;
    private TreeNode xParent;
    private TreeNode yParent;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return true;
        dfs(root, x, y, 0, null);
        return (xdep == ydep && xParent != yParent);
    }

    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        // edge
        if (root == null)
            return;
        if (root.val == x) {
            xdep = depth;
            xParent = parent;
        }
        if (root.val == y) {
            ydep = depth;
            yParent = parent;
        }
        // logic
        dfs(root.left, x, y, depth + 1, root);
        dfs(root.right, x, y, depth + 1, root);
    }
}