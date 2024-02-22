// TC - O(N)
// SC - O(h)

// Constraints:
// The number of nodes in the tree is in the range [2, 100].
// 1 <= Node.val <= 100
// Each node has a unique value.
// x != y
// x and y are exist in the tree.

public class TreeCousinsDFS {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        private int x_depth;
        private int y_depth;
        private TreeNode x_parent;
        private TreeNode y_parent;

        public boolean isCousins(TreeNode root, int x, int y) {
            dfs(root, null, 0, x, y);
            return x_depth == y_depth && x_parent != y_parent;
        }

        private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y) {
            if (root == null) {
                return;
            }

            if (root.val == x) {
                x_depth = depth;
                x_parent = parent;
            } else if (root.val == y) {
                y_depth = depth;
                y_parent = parent;
            }

            dfs(root.left, root, depth + 1, x, y);
            if (x_parent == null || y_parent == null) {
                dfs(root.right, root, depth + 1, x, y);
            }
        }
    }
}
