// Time Complexity : o(n)
// Space Complexity : o(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    int xx;
    int yy;
    int xdepth;
    int ydepth;
    int xprev;
    int yprev;
    public boolean isCousins(TreeNode root, int x, int y) {
        xx=x;
        yy=y;
        helper(root,0,0);
       
        if(xdepth==ydepth && xprev!=yprev){
            return true;
        }
        return false;
    }
    private void helper(TreeNode root,int depth,int prevvalue){
        if(root==null)return;
        
        if(root.val==xx){
            xdepth=depth;
            xprev=prevvalue;
        }
        if(root.val==yy){
            ydepth=depth;
            yprev=prevvalue;
        }
        
        helper(root.left,depth+1,root.val);
        helper(root.right,depth+1,root.val);
    }
}