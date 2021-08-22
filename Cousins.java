/* Time Complexity :  O(n)
   Space Complexity :  O(h) where h is recursive stack space 
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
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
       TreeNode root_x,root_y;
    int depth_x,depth_y;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,null,x,y,0);
        return depth_x==depth_y && root_x!=root_y;
    }
    private void dfs(TreeNode root,TreeNode parent, int x,int y,int level){
        if(root==null){
            return;
        }
        if(root.val==x){
            root_x=parent;
            depth_x=level;
        }
        if(root.val==y){
            root_y=parent;
            depth_y=level;
        }
        if(root_x!=null && root_y !=null){
            return;
        }
        //logic
        dfs(root.left,root,x,y,level+1);
        dfs(root.right,root,x,y,level+1); 
    }
}