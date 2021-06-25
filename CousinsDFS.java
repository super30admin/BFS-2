// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package bfs2;

public class CousinsDFS {

    int depthX, depthY;
    TreeNode parentX, parentY;
    boolean flagX, flagY;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return depthX == depthY && parentX != parentY;
    }

    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            depthX = depth;
            parentX = parent;
        }
        if (root.val == y) {
            depthY = depth;
            parentY = parent;
        }
        dfs(root.left, root, depth + 1, x, y);
        if (!(flagX && flagY)) {
            dfs(root.right, root, depth + 1, x, y);
        }
    }
}
