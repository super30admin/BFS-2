class Solution {
    int Xparent, Yparent, Xlevel, Ylevel; 
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root== null)  return false;
        dfs(root,0,x,y);
        if(Xparent!= Yparent && Xlevel== Ylevel) return true;
        return false;
    }
    private void dfs(TreeNode root, int level, int x, int y){
        if(root== null) return;
        if(root.right!= null){
            if(root.right.val ==x){
            Xparent= root.val;
            Xlevel=level+1;
        } 
            if(root.right.val==y ){
            Yparent= root.val;
            Ylevel=level+1;
        }
        }
        if(root.left!= null){
                if(root.left.val ==x){
            Xparent= root.val;
            Xlevel=level+1;
        } 
            if( root.left.val ==y){
            Yparent= root.val;
            Ylevel=level+1;
        }
        }
        dfs(root.left,level+1, x,y);
        dfs(root.right,level+1, x,y);
    }
}
//time complexity- O(n)
//space complexity - O(1)