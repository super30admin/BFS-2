//TC: O(n)
//SC: O(h)
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
    int x_d;
    int y_d;
    TreeNode x_p;
    TreeNode y_p;
    private void helper(TreeNode root, int x, int y, int depth,TreeNode parent)
    {
        if(root==null)
        return;
        if(root.val==x)
        {
            x_d=depth;
            x_p=parent;
        }
           if(root.val==y)
        {
            y_d=depth;
            y_p=parent;
        }

        helper(root.left,x,y,depth+1,root);
        helper(root.right,x,y,depth+1,root);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,x,y,0,null);
        return (y_p!=x_p)&&(x_d==y_d);
        
    }
}