
//Time :O(N)
//Space :O(1)
class Solution {
    int depthX = -1;
    int depthY = -1;
    TreeNode parentX = null;
    TreeNode parentY = null;

    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null)
            return false;
        recur(root, x, y, 0, root);
        return (depthX == depthY) && (parentX != parentY);

    }

    public void recur(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if (root == null)
            return;

        if (root.val == x) {
            depthX = depth;
            parentX = parent;
        } else if (root.val == y) {
            depthY = depth;
            parentY = parent;
        }

        recur(root.left, x, y, depth + 1, root);
        recur(root.right, x, y, depth + 1, root);
    }
}