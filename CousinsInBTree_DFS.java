// Time Complexity : O(n) --> where n is number of nodes in the tree  
// Space Complexity : O(h)
// Did this code successfully run on Leetcode (993): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_depth;
    int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        dfs(root, 0, null, x, y);
        return x_parent != y_parent && x_depth == y_depth;
    }
    
    private void dfs(TreeNode root, int depth, TreeNode parent, int x, int y) {
        // base case
        if (root == null) return;
        // logic
        if (root.val == x) {
            x_parent = parent;
            x_depth = depth;
        }
        
        if (root.val == y) {
            y_parent = parent;
            y_depth = depth;
        }
        dfs(root.left, depth + 1, root, x, y);
        dfs(root.right, depth + 1, root, x, y);
    }
}