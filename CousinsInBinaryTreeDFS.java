// Time Complexity : O(n) => As we iterate over the n nodes
// Space Complexity : O(h) //Recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach : Using DFS(Level Order Traversal). To the dfs() pass level, parent and set the x_parent, y_parent & x_depth, y_depth. Finally check if x_parent should not be same as y_parent but x_depth should be same as y_depth then return true else return false.
 */
class Solution {
    TreeNode x_parent, y_parent;
    int x_depth, y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {

        if(root == null){
            return false;
        }

        dfs(root, 0, null, x, y);

        return ((x_depth == y_depth) && (x_parent != y_parent));
    }

    private void dfs(TreeNode root, int level, TreeNode parent, int x, int y){

        if(root == null){
            return;
        }

        if(root.val == x){
            x_parent = parent;
            x_depth = level;
        }

        if(root.val == y){
            y_parent = parent;
            y_depth = level;
        }

        dfs(root.left, level+1, root, x, y);
        dfs(root.right, level+1, root, x, y);
    }
}