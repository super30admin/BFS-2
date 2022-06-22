// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {

    TreeNode parent_x;
    TreeNode parent_y;
    int level_x;
    int level_y;

    private void dfs(TreeNode root, int x, int y, int level, TreeNode parent) {

        if (root == null) return;

        if (root.val == x) {
            parent_x = parent;
            level_x = level;
        }

        if (root.val == y) {
            parent_y = parent;
            level_y = level;
        }

        dfs(root.left, x, y, level + 1, root);
        dfs(root.right, x, y, level + 1, root);
    }

    public boolean isCousins(TreeNode root, int x, int y) {

        dfs(root, x, y, 0, null);

        // If Parent are not same and the same level then cousins
        return (parent_x != parent_y && level_x == level_y);

    }
}