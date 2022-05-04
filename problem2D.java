import javax.swing.tree.TreeNode;

class cousinsInBinaryTree{
    TreeNode x_parent, y_parent;
    int x_lvl, y_lvl;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;   

        helper(root, 0, null, x, y);

        return x_lvl == y_lvl && x_parent !=y_parent;
    }

    private void helper(TreeNode root, int lvl, TreeNode parent, int x, int y){
        if(root == null){
            return;
        }
        if(root.val == x){
            x_lvl = lvl;
            x_parent = parent;
        }
        if(root.val == y){
            y_lvl = lvl;
            y_parent = parent;
        }
        if(x_parent == null || y_parent == null){
            helper(root.left, lvl+1, root, x, y);
            helper(root.right, lvl+1, root, x, y);
        }
    }
}