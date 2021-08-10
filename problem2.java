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
    
    TreeNode x_parent= null, y_parent= null;
      int x_depth=-1, y_depth=-1;
      
  public boolean isCousins(TreeNode root, int x, int y) {
      
    
      depthandParent(root, 0, null, x, y);
      return x_depth== y_depth && x_parent!= y_parent;
  }
  
  
  public void depthandParent(TreeNode root, int height, TreeNode parent, int x, int y){
      
      if(root==null) return ;
      
      //dfs, by keeping track of depth and parent both as we go from top-down!
      if(root.val==x){
          x_depth=height;
          x_parent= parent;
      }
      else if(root.val==y){
          y_depth= height;
          y_parent= parent;
      }
      
      depthandParent(root.left, height+1, root,x,y);
      depthandParent(root.right, height+1, root, x,y);
      
      
  
  }
}