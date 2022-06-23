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
  
  //TC:O(n) SC:O(height)
    int xheight;
    int yheight;
    TreeNode xparent;
    TreeNode yparent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,null,0,x,y);
        if(xparent!=yparent && xheight==yheight)return true;
        return false;
    }
    void dfs(TreeNode root, TreeNode parent,int level, int x, int y){
        //base
        if(root==null)return ;
        //logic
        if(root.val==x){
            xparent=parent;
            xheight=level;
            
        }
        if(root.val==y){
            yparent=parent;
            yheight=level;
            
        }
        dfs(root.left,root,level+1,x,y);
        dfs(root.right,root,level+1,x,y);
        
    }}
