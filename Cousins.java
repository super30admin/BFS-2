//space complexity:O(H);
//Time complexity:O(N);
public class Cousins {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_level;
    int y_level;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        helper(root,x,y,0,null);
        return x_level==y_level && x_parent!=y_parent;
    }
    private void helper(TreeNode root,int x,int y,int lvl,TreeNode parent){
        if(root==null) return;
        if(root.val==x){
            x_parent=parent;
            x_level=lvl;
        }
        if(root.val==y){
            y_parent=parent;
            y_level=lvl;
        }
        helper(root.left,x,y,lvl+1,root);
        helper(root.right,x,y,lvl+1,root);
    }
}
