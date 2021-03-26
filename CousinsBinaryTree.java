// Time Complexity : O(n); n = #nodes
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class CousinsBinaryTree {
    class TreeNode {
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
        int parentX = -1, parentY = -1;
        int dX = -1, dY = -1;

        public boolean isCousins(TreeNode root, int x, int y) {
            recur(root, x, y, -1, 0);
            if (parentX == -1 || parentY == -1) return false;
            return (parentX != parentY) && (dX == dY);
        }

        private void recur(TreeNode root, int x, int y, int parent, int level) {
            if (root == null) return;

            if (x == root.val) {
                parentX = parent;
                dX = level;
            }
            if (y == root.val) {
                parentY = parent;
                dY = level;
            }
            recur(root.left, x, y, root.val, level + 1);
            recur(root.right, x, y, root.val, level + 1);

        }
}
