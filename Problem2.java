// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Iterating the tree and saving the both x, y's level and parent nodes. If they are on same level with different parents, they are cousins. Otherwise they are not.
 */
class Solution {
    int x_level;
    int y_level;
    TreeNode x_parent;
    TreeNode y_parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, x, y, 0);
        return x_level == y_level && x_parent != y_parent;
    }

    private void dfs(TreeNode node, TreeNode parent, int x, int y, int level) {
        if (node == null)
            return;
        // if both x and y are found, no need to iterate through the tree since the elements are unique
        if (x_parent != null && y_parent != null)
            return;

        if (node.val == x) {
            x_level = level;
            x_parent = parent;
        } else if (node.val == y) {
            y_level = level;
            y_parent = parent;
        }

        dfs(node.left, node, x, y, level + 1);
        dfs(node.right, node, x, y, level + 1);
    }
}