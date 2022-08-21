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
    TreeNode xParent,yParent;
    int xd,yd;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(x == root.val || y == root.val) return false;
        depth(null,root,x,y,0);
        return xd == yd && xParent !=yParent;
    }
    
    public void depth(TreeNode parent,TreeNode root,int x,int y,int depth){
        if(root == null) return ;
        if(root.val == x){
            xParent =parent;
            xd =  depth;
        }
        if(root.val == y){
            yParent =parent;
            yd =  depth;
        }
        depth(root,root.left,x,y,depth+1);
        depth(root,root.right,x,y,depth+1);
    }
}
