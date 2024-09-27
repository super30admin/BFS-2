// Time Complexity : O(N) - As we iterate through all the nodes in the tree
// Space Complexity : O(N) - AS We use recursion(Internal Stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
 */ /*Used two functions one to find the depth of each node and the other to find ancestors.
      If depths are equal and ancestors are not equal implies they are cousins */
class Solution {
    public int height(TreeNode root,int data,int level){
       if(root == null) return 0;
        
        if(root.val == data) return level;
        
        int leftlevel = height(root.left,data,level + 1);
            if(leftlevel > 0) return leftlevel;
          else{
              return height(root.right,data,level + 1);
          }
    }
    public TreeNode Ancestor(TreeNode root,int x){
        if(root == null) return null;
        if(root.right != null && root.right.val == x || root.left != null && root.left.val == x) return root;
        TreeNode a1 = Ancestor(root.right,x);
        if(a1 != null) return a1;
        else{
            return Ancestor(root.left,x);
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
         if(height(root,x,0) == height(root,y,0) && Ancestor(root,x) != Ancestor(root,y)) return true;
        else{
            return false;
        }
        
    }
}
// Your code here along with comments explaining your approach