// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : later realized two nodes can't have same parent

public class cousinsInTree {
    TreeNode parentx;
    TreeNode parenty;
    int depthx;
    int depthy;

    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, null, x, y, 0);
        return parentx != parenty && depthx == depthy;
    }

    private void helper(TreeNode root, TreeNode parent, int x, int y, int level) {
        if (root == null)
            return;

        if (root.val == x) {
            parentx = parent;
            depthx = level;
        }

        if (root.val == y) {
            parenty = parent;
            depthy = level;
        }

        if (parentx == null || parenty == null) {
            helper(root.left, root, x, y, level + 1);
            helper(root.right, root, x, y, level + 1);
        }

    }
}
