// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 102
//Approach : DFS

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
    
      //variables to store the x and y parents and levels
      TreeNode x_parent, y_parent;   
      int x_level, y_level;
    public boolean isCousins(TreeNode root, int x, int y) {
      //Edge  
      if(root == null) return false;

      dfs(root, null , x, y, 0); 
              
      return (x_parent != y_parent && x_level == y_level);  
    }
          
      private void dfs(TreeNode root, TreeNode parent , int x , int y, int level){
          
          //base
          if(root == null) return;
          //logic 
         if(root.val == x){
            x_parent = parent;
            x_level = level;
          } 
          if(root.val == y ){
             y_parent = parent;
             y_level = level;
          } 
          dfs(root.left, root, x,y, level+1);
          dfs(root.right, root, x,y, level+1);                 
    }
}