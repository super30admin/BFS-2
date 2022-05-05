// tc o(n) sc o(H)
//simple dfs problem

class Solution {
    TreeNode x_parent, y_parent;
    int x_lvl, y_lvl;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }
        dfs(root, 0, null, x, y);
        return x_parent != y_parent && x_lvl == y_lvl;
    }
    private void dfs(TreeNode root, int lvl, TreeNode parent, int x, int y) {
        if(root == null) {
            return;
        }
        if(root.val == x) {
            x_lvl = lvl;
            x_parent = parent;
        }
        if(root.val == y) {
            y_lvl = lvl;
            y_parent = parent;
        }
        
        if(x_parent == null || y_parent == null) {
        dfs(root.left, lvl + 1, root, x, y);
        dfs(root.right, lvl + 1, root, x, y);
     }
    }
}