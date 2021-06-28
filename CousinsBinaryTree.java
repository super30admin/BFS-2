class CousinsBinaryTree{


    // DFS
    int x_depth, y_depth;
    TreeNode x_parent, y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        if(x_depth == y_depth && x_parent != y_parent) return true;
        return false;
    }

    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y){
        //base
        if(root == null) return;

        //logic
        if(root.val == x){
            x_depth = depth;
            x_parent = parent;
        } else if(root.val == y){
            y_depth = depth;
            y_parent = parent;
        }
        dfs(root.left, root, depth+1, x, y);
        dfs(root.right, root, depth+1, x, y);
    }
}