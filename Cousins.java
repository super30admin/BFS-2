class Cousins{
    int x_depth;
    int y_depth;
    TreeNode xparent;
    TreeNode yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null )return false;

        _dfs(root,0,null,x,y);
        if(x_depth==y_depth){
            if(xparent!=yParent){
                return true;
            }
        }
        return false;
    }

    private void _dfs(TreeNode node,int level,TreeNode parent,int x,int y){
        //base
        if(node==null)return;
        //logic
        if(node.val == x){
            xparent = parent;
            x_depth=level;
        }
        if(node.val == y){
            yParent = parent;
            y_depth = level;
        }
        _dfs(node.left,level+1,node,x,y);
        _dfs(node.right,level+1,node,x,y);


    }
    //TIme complexity : o(n)
    //space complexity : logn -> maximum depth of tree
    //populate global variable of x-depth,ydepth ,xparent and yparent and check if they are in same level with different parents
}