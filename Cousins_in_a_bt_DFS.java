

class Solution {
    TreeNode x_parent = null;
    TreeNode y_parent = null;
    int x_depth = -1;
    int y_depth = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,x,y,0,null);
        return x_depth == y_depth && x_parent != y_parent;
        
    }
    private void helper(TreeNode root, int x, int y, int depth, TreeNode parent){
        //base case
        if(root == null) return;
        if(root.val == x) {x_depth = depth;x_parent = parent;}
        if(root.val == y) {y_depth = depth;y_parent = parent;}
        
        helper(root.left,x,y,depth+1,root);
        helper(root.right,x,y,depth+1,root);
        
        return ;
    }
}
