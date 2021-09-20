/**
 * Time complexity is O(n) - visiting every single node - Space complexity is
 * O(1) - no extra memeory is used
 * 
 * Problem is to validate the given cousins in the tree. Using depth first in
 * the recursive manner we can traverse through the tree and store the parents
 * and levels in variables and compaire them at the end
 */

public class CousineDFS {
    TreeNode x_parent = null;
    TreeNode y_parent = null;
    int x_depth = -1;
    int y_depth = -2;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (x == y || root == null)
            return false;

        helper(root, null, x, y, 1);
        if (x_parent != y_parent && x_depth == y_depth)
            return true;
        return false;
    }

    public void helper(TreeNode root, TreeNode parent, int x, int y, int level) {
        if (root == null)
            return;

        if (root.val == x || root.val == x) {
            x_parent = parent;
            x_depth = level;
        } else if (root.val == y || root.val == y) {
            y_parent = parent;
            y_depth = level;
        }

        helper(root.left, root, x, y, level + 1);
        helper(root.right, root, x, y, level + 1);

    }
}
