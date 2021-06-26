//Time Complexity - O(n)
//Space Complexity - O(h)

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
    int xdepth; int ydepth;
    TreeNode xParent; TreeNode yParent;
  
    public boolean isCousins(TreeNode root, int x, int y) {
      if(root == null || root.val == x || root.val == y) return false;
      dfs(root,null,0,x,y);
      return xParent != yParent && xdepth == ydepth;
        
    }
  
    public void dfs(TreeNode root, TreeNode parent, int depth, int x, int y) {
      //base
      if(root == null) return;
      
      //logic
      //if the value x and y found then record parent and level
      if(root.val == x) {
        xdepth = depth;
        xParent = parent;
      }
      if(root.val == y) {
        ydepth = depth;
        yParent = parent;
      }
      //if not found continue search in left subtree and then right
      dfs(root.left,root, depth+1, x,y);
      dfs(root.right,root, depth+1, x,y);
      
    }
}