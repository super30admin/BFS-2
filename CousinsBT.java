// Time Complexity : O(n) where n is total no of nodes
// Space Complexity :  O(h) for recursive stack(dfs) which at most stores the height of the tree;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.

class CousinsBT {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_ht; int y_ht;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        dfs(root, null, 0 , x, y);
        return x_parent!=y_parent && x_ht==y_ht;
        //Returns true only when the nodes don't have the same parent, and they are on the same level.
    }
    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y){
        if(root == null) return;

        if(root.val == x){
            x_parent = parent;
            x_ht = level;
        }
        if(root.val == y){
            y_parent = parent;
            y_ht = level;
        }
        if(x_parent == null || y_parent == null){
            dfs(root.left, root, level+1, x, y);
        }
        if(x_parent == null || y_parent == null){
            dfs(root.right, root, level+1, x, y);
        }

    }
}