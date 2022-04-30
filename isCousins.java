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
//TC : O(N) SC : O(H) where H is height of the tree
class Solution {
    Integer xHeight,yHeight,xParent,yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        xHeight=null;
        yHeight=null;
        xParent=null;
        yParent=null;
        helper(root,0,null,x,y);
        if(xHeight==yHeight && xParent!=yParent)
            return true;
        else
            return false;
    }

    private void helper(TreeNode root,int height,TreeNode parent,int x,int y)
    {
        //base
        if(root==null) return;
        if(xParent!=null && yParent!=null) return;
        //logic
        if(root.val == x)
        {
            xHeight = height;
            if(parent!=null)
                xParent = parent.val;
        }
        if(root.val == y)
        {
            yHeight = height;
            if(parent!=null)
                yParent = parent.val;
        }

        helper(root.left,height+1,root,x,y);
        helper(root.right,height+1,root,x,y);
    }
}