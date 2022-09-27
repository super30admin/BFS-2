
//Time Complexity: O(n)
//Space Complexity: O(n)


class Solution {
    int x_depth;
        int y_depth;
        TreeNode x_parent;
        TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null || x==y) return false;
        dfs(root,0,null,x,y);
        return x_depth==y_depth && x_parent!=y_parent;
        
    }
    private void dfs(TreeNode root, int lvl, TreeNode parent, int x, int y){
        if(root==null) return;
        if(root.val==x){
            x_depth=lvl;
            x_parent=parent;
        }
        if(root.val==y){
            y_depth=lvl;
            y_parent=parent;
        }
        dfs(root.left,lvl+1,root,x,y);
        dfs(root.right,lvl+1,root,x,y);
    }
}