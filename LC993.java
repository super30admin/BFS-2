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
    
    TreeNode x_parent;
    TreeNode y_parent;
    
    int x_ht;
    int y_ht;
    
    public boolean isCousins(TreeNode root, int x, int y) {
     
        dfs(root,x,y,0,null);
        
        return x_ht==y_ht && x_parent!=y_parent;
    }
    
    private void dfs(TreeNode root, int x, int y, int height, TreeNode parent)
    {
        
        if(root==null)
        {
            return;
        }
        
        if(root.val == x)
        {
            x_ht = height;
            x_parent = parent;
        }
        
        if(root.val == y)
        {
            y_ht = height;
            y_parent = parent;
        }
        
        dfs(root.left,x,y,height+1,root);
        dfs(root.right,x,y,height+1,root);
    }
}
