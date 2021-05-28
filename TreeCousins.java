// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We search through the entire tree, and try to find the element x and y 
    along with their corresponding parent and depth
*/

class Solution {
    int xd, yd, xp, yp;
    public void depth(TreeNode node, int x, int y, int deep, int par){
        if(node==null)
            return;
        if(node.val==x)
        {
            xp=par;
            xd=deep;
            return;
        }
        if(node.val==y)
        {
            yp=par;
            yd=deep;
            return;
        }
        depth(node.left,x,y,deep+1,node.val);
        depth(node.right,x,y,deep+1,node.val);
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        xd = 0;
        yd = 0;
        xp = 0;
        yp = 0;
        depth(root.left,x,y,1,root.val);
        depth(root.right,x,y,1,root.val);
        if((xd==yd)&&(xp!=yp))
            return true;
        return false;
    }
}