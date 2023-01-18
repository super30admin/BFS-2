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
    
    int xheight = 0;
    int yheight = 0;
    TreeNode xparent = null;
    TreeNode yparent = null;
    int xvalue = 0;
    int yvalue = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        xvalue = x;
        yvalue = y;
        
        helper(root, 0, root);
         //helper(root, 0, root);
        
       // System.out.println(xheight);
        //System.out.println(yheight);
        //System.out.println(xparent.val);
        //System.out.println(yparent.val);
        if((xheight == yheight) && xparent != yparent){
            return true;
        }
        
        return false;
    }
    
    public void helper(TreeNode root, int h, TreeNode parent){
        
        h = h + 1;
        //System.out.println(parent.val);
        
        if(root == null){
            return;
        }
        
        else if(root.val == xvalue){
            xheight = h;
            xparent = parent;
            
        }
        
        else if(root.val == yvalue){
            
            yheight = h;
            yparent = parent;
            
        }
        
        helper(root.left, h, root);
        helper(root.right, h, root);
        
    }
}