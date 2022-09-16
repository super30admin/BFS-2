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
//tc- o(n)
//sc-o(h)
class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        flag = true;
        dfs(root.left,root.right);
        return flag;
    }
    //void
    private void dfs(TreeNode left,TreeNode right)
    {
        //base case
        if(left == null && right == null) return;
        if(left==null || right == null || left.val != right.val)
        {
            flag = false;
            return;
        }
        //logic
        if(flag)
        dfs(left.left,right.right);
        if(flag)
        dfs(left.right,right.left);
        
    }
    //bool
    private boolean dfs(TreeNode left,TreeNode right)
    {
        //base case
        if(left == null && right == null) return true;
        if(left==null || right == null || left.val != right.val)
        {
          return false;
        }
        //logic
       return dfs(left.left,right.right)&&dfs(left.right,right.left);
        
             
    }

}