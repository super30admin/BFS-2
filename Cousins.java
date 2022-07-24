// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes

class Solution {
    boolean res;
    TreeNode x_p;
    TreeNode y_p;
    int x_l;
    int y_l;
    public boolean isCousins(TreeNode root, int x, int y) {
        res = false;
        if(root == null){
            return false;
        }
        helper(root,x,y,0,null);
        return x_p != y_p && x_l == y_l;
    }
    void helper(TreeNode root,int x,int y,int level,TreeNode p){
        if(root == null) return;
        if(x == root.val){
            x_l = level;
            x_p = p;
        }
        if(y == root.val){
            y_l = level;
            y_p = p;
        }
        if((x_p==null) || (y_p==null)){
            helper(root.left,x,y,level+1,root);
            helper(root.right,x,y,level+1,root);
        }
    }
}