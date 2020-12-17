// Time Complexity :O(N)
// Space Complexity :O(H) where h is the height of the tree 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach:Storing the value of the depth and parents of both x and y and checking 
// the condition
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
    int xd, yd;
    TreeNode xp,yp;
    public boolean isCousins(TreeNode root, int x, int y) {
            
            dfs(root,x,y,0);
            dfs(root,x,y,0);
        if(xp==null || yp==null)
            return false;
        if(xd==yd && xp!=yp)
            return true;
        return false;
    }
    public void dfs(TreeNode root, int x, int y,int level) {
        if(root==null)
            return;
        if(xp!=null && yp!=null)
            return;
        level=level+1;
            if(root.left!=null && root.left.val==x){
                xp= root;
                xd=level;
            }
        else if(root.left!=null && root.left.val==y){
                yp= root;
                yd=level;
            }
        else if(root.right!=null && root.right.val==y){
                yp= root;
                yd=level;
            }
        else if(root.right!=null && root.right.val==x){
                xp= root;
                xd=level;
            
                    }

            dfs(root.left,x,y,level);
            dfs(root.right,x,y,level);
    }
}