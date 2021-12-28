//approach: DFS
class Solution {
    TreeNode x_parent, y_parent; //Treenode default is null
    int x_level, y_level; // int default is 0
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        dfs(root, x, y, 0, null);
        return x_parent != y_parent && x_level == y_level;
    }
    private void dfs(TreeNode root, int x, int y, int lvl, TreeNode parent) {
        //base
        if (root == null){
            return;
        }
        if (x_parent != null && y_parent != null){
            return;
        }
        //logic
        if (root.val == x){
            x_parent = parent;
            x_level = lvl;
        }
        if (root.val == y){
            y_parent = parent;
            y_level = lvl;
        }
        dfs(root.left, x, y, lvl + 1, root);
        dfs(root.right, x, y, lvl + 1, root);
    }
}