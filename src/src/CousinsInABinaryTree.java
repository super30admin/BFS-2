public class CousinsInABinaryTree {


    /*
    TC : O(N) where N is the number of nodes in the binary tree
    SC : O(N)
    LC : yes
    problems : No
     */

    /**
     * Basically we perform DFS and iterate over all nodes to store parents and depth of both x and y.
     */
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
    boolean flag_x = false;
    boolean flag_y = false;

    public boolean isCousins(TreeNode root, int x, int y) {


        helper(root, null, 0, x, y);
        return x_depth == y_depth && x_parent != y_parent;

    }

    public void helper(TreeNode root, TreeNode parent, int depth, int x, int y) {
        if (root == null)
            return;
        if (root.val == x) {
            x_depth = depth;
            x_parent = parent;
            flag_x = true;
        }

        if (root.val == y) {
            y_depth = depth;
            y_parent = parent;
            flag_y = true;
        }

        helper(root.left, root, depth + 1, x, y);
        if (flag_x && flag_y) {

        } else
            helper(root.right, root, depth + 1, x, y);
    }
}
