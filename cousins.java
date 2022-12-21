//TC: O(n)
//SC: O(h)
// apprroach : dfs
public class cousins {
    class Solution {
        TreeNode xParent = null, yParent = null;
        int xDepth = -1, yDepth = -2;
        public boolean isCousins(TreeNode root, int x, int y) {
            dfs(root, null, x, y, 0);
            return xDepth == yDepth && xParent != yParent;
        }
        void dfs(TreeNode root, TreeNode parent, int x, int y, int depth) {
            if (root == null) return;
            if (x == root.val) {
                xParent = parent;
                xDepth = depth;
            } else if (y == root.val) {
                yParent = parent;
                yDepth = depth;
            } else {
                // if we found x node or found y node then we don't need to dfs deeper
                //     because x and y must be the same depth
                dfs(root.left, root, x, y, depth + 1);
                dfs(root.right, root, x, y, depth + 1);
            }
        }
    }
}
