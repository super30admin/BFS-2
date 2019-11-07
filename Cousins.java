//Time Complexity :O(N)
//Space Complexity :O(1) + recursion stack.
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach
class Cousins {
    TreeNode xParent = null, yParent = null;
    int xDepth = 0, yDepth = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(null == root || x == y){return false;}
        isCousins(root,x,y,0,null);
        return  xParent != yParent && xDepth == yDepth;
    }
    public void isCousins(TreeNode root, int x, int y, int depth, TreeNode prev){
        if(null == root){
            return;
        }
        if(root.val == x){
            xParent = prev;
            xDepth = depth;
        }
        if(root.val == y){
            yParent = prev;
            yDepth = depth;
        }
        isCousins(root.left,x,y,depth+1,root);
        isCousins(root.right,x,y,depth+1,root);
    }
}