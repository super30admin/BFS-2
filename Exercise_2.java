class Solution {
    int x, y;
    int xl, yl;
    TreeNode xp, yp;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        algo(root,0,null);
        return xl==yl && xp!=yp;
    }
    private void algo(TreeNode n, int l, TreeNode p) {
        if(n==null){
            return;
        }
        if(n.val == x){
            xl=l;
            xp=p;
        }
        if(n.val == y){
            yl=l;
            yp=p;
        }
        algo(n.left,l+1,n);
        algo(n.right,l+1,n);
    }
}
//tc=O(n)
//sc=O(n)
