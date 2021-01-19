// https://leetcode.com/problems/cousins-in-binary-tree/
// Time complexity : O(N)
// Space complexity : O(1) Ignoring recursion stack

class Solution {
    int parent_x = -1;
    int level_x = -1;
    int parent_y = -1;
    int level_y = -1;
   public boolean isCousins(TreeNode root, int x, int y) {
       helper(root,-1,0,x,y);
       return (level_x == level_y) && (parent_x != parent_y);
   }
   public void helper(TreeNode root,int parent,int level,int x,int y){
       if(root == null)
           return;
       
       if(root.val == x){
           parent_x = parent;
           level_x = level;
       }
       if(root.val == y){
           parent_y = parent;
           level_y = level;
       }
       
       helper(root.left,root.val,level+1,x,y);
       helper(root.right,root.val,level+1,x,y);
   }
}