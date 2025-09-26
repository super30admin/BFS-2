// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    int x_level, y_level;
    TreeNode x_parent, y_parent;

    public boolean isCousins(TreeNode root, int x, int y) {

        helper(root, x, y, 0, null);
        return x_level == y_level && x_parent != y_parent;
    }

    private void helper(TreeNode root, int x, int y, int level, TreeNode parent){
        // base case
        if(root == null) return;

        if(root.val == x){
            x_level = level;
            x_parent = parent;
        }

        if(root.val == y){
            y_level = level;
            y_parent = parent;
        }

        helper(root.left, x, y, level+1, root);

        helper(root.right, x, y, level+1, root);
    }
}
