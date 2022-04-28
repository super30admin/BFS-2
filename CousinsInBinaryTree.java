// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int x_level, y_level;
    TreeNode x_parent, y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)return true;
        dfs(root, x, y, 0, null);
        return x_level == y_level && x_parent != y_parent;
    }
    
    private void dfs(TreeNode root,int x, int y, int level, TreeNode parent) {
        if(root == null) return;
        
        if(root.val == x) {
            x_level = level;
            x_parent = parent;
        }

        if(root.val == y) {
            y_level = level;
            y_parent = parent;
        }
        
        dfs(root.left, x, y, level + 1, root);
        dfs(root.right, x, y, level + 1, root);
    }
}