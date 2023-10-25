//T.C-O(n)
//S.C-O(1)
//passed all test cases
// the approach is to maintain the levels of two nodes and thier parent nodes.
class Solution {
    TreeNode parent_x = null;
    TreeNode parent_y = null;
    int d1 = 0;
    int d2 = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, null, x, y, 0);
        return d1 == d2 && parent_x != parent_y;
    }

    public void helper(TreeNode root, TreeNode parent, int x, int y, int level) {
        // base
        if (root == null)
            return;
        // logic
        if (root.val == x) {
            d1 = level;
            parent_x = parent;
        }
        if (root.val == y) {
            d2 = level;
            parent_y = parent;
        }
        helper(root.left, root, x, y, level + 1);
        helper(root.right, root, x, y, level + 1);
    }
}