// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    TreeNode xParent;
    TreeNode yParent;
    int xLevel;
    int yLevel;
    public boolean isCousins(TreeNode root, int x, int y) {
        // call the recursive function
        dfs(root, x, y, 0, null);
        //return true only if the parents of both the nodes are not same and at the same level
        return (xLevel == yLevel && xParent != yParent);
    }
    private void dfs(TreeNode root, int x, int y, int level, TreeNode parent){
        // base
        // return if leaf node is reached
        if(root == null) return;
        // logic
        // if x is found, get its parent node and level
        if(root.val == x) {
            xParent = parent;
            xLevel = level;
        }
        // if y is found, get its parent node and level
        if(root.val == y){
            yParent = parent;
            yLevel = level;
        }
        // call the recursive function on left and right children nodes
        dfs(root.left, x, y, level + 1, root);
        dfs(root.right, x, y, level + 1, root);
    }
}