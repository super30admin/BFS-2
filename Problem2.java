// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

/**
 * We can solve this problem using DFS and BFS.
 * DFS - We can start from the root and keep track of the depth of the x and y nodes.
 * If the depth of the x and y nodes is equal and the parent of the x and y nodes is not equal,
 * then we can return true.
 * BFS - We can use another queue i.e parent queue to keep track of the parent of the x and y nodes.
 * If the depth of the x and y nodes is equal and the parent of the x and y nodes is not equal,
 * then we can return true.
 */

public class Problem2 {
    int xDepth;
    int yDepth;
    TreeNode x_parent;
    TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return x_parent != y_parent && xDepth == yDepth;
    }

    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y) {
        //base
        if(root == null) return;
        //logic
        dfs(root.left, root, level+1, x, y);
        if(root.val == x) {
            xDepth = level;
            x_parent = parent;
        }

        if(root.val == y) {
            yDepth = level;
            y_parent = parent;
        }

        dfs(root.right, root, level+1, x, y);
    }
}
