class CousinsInTree {
    int level_x, level_y;
    TreeNode parent_x, parent_y;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }

        level_x = -1;
        level_y = -1;
        parent_x = null;
        parent_y = null;

        dfs(root, null, 0, x, y);
        return level_x == level_y && parent_x != parent_y;
    }

    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y){
        if(root == null || (level_x!=-1 && level_y!=-1)) {
            return;
        }

        //logic
        if(root.val == x){
            parent_x = parent;
            level_x = level;
        }
        if(root.val == y){
            parent_y = parent;
            level_y = level;
        }

        dfs(root.left, root, level+1, x, y);
        dfs(root.right, root, level+1, x, y);
    }
}
