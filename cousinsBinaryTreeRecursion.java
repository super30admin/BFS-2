// Time complexity - O(n)
// Space complexity - O(h) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
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
    TreeNode parent_x;
    TreeNode parent_y;
    int level_x;
    int level_y;
  
    public boolean isCousins(TreeNode root, int x, int y) {
        
        dfs(root, x, y, 0,null);
        
        if(parent_x != parent_y && level_x == level_y){
            //System.out.println(parent_x);
            //System.out.println(level_x);
            //System.out.println(parent_y);
            //System.out.println(level_y);
            return true;
        }
        return false;
    }
    
    private void dfs(TreeNode root,int x, int y, int level, TreeNode parent ){
        
        //base case
        if(root == null){
            
            return;
        }
        if(root.val == x ){
            
            parent_x = parent;
            level_x = level;
        }
         if(root.val == y ){
            
            parent_y = parent;
            level_y = level;
        }
        
        dfs(root.left,x,y,level+1,root);
        dfs(root.right,x,y,level+1,root);
        
    }
}