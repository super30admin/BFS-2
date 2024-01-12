// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    TreeNode parent_x;
    TreeNode parent_y;
    int depth_x;
    int depth_y;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return parent_x!=parent_y && depth_x==depth_y;
    }
    public void dfs(TreeNode root, TreeNode parent, int depth, int x, int y){
        if(root==null) return;
        if(root.val == x) {
            parent_x=parent;
            depth_x=depth;
        }
        if(root.val == y) {
            parent_y=parent;
            depth_y=depth;
        }
        if(parent_x==null || parent_y==null) dfs(root.left, root, depth+1, x, y);
        if(parent_x==null || parent_y==null) dfs(root.right, root, depth+1, x, y);
    }
}