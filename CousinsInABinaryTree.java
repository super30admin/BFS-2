//Time Complexity-O(n)
//Space complexity-O(1) //Since we are using recursion. For recursive stack, it is going to be O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int depthX=-1;
    private int depthY=-1;
    private TreeNode parentX=null;
    private TreeNode parentY=null;
        
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
        {
            return false;
        }
        //We found the cousins
        if(depthX!=-1 && depthY!=-1)
        {
            return true;
        }
        recur(root,x,y,null,0);
        return (depthX==depthY)&&(parentX!=parentY);
    }
    private void recur(TreeNode root,int x,int y,TreeNode parent,int depth)
    {
        if(root==null)
        {
            return;
        }
        if(root.val==x)
        {
            parentX=parent;
            depthX=depth;
        }
        else if(root.val==y)
        {
            parentY=parent;
            depthY=depth;
        }
        recur(root.left,x,y,root,depth+1);
        recur(root.right,x,y,root,depth+1);
    }

}