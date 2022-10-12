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
    int x_level,y_level;
    TreeNode x_parent,y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root==null || root.val==x || root.val==y) return false;
        
        dfs(root,x,y,null,0);
        System.out.println(x_parent.val+" "+y_parent.val);
        return x_parent!=y_parent && x_level==y_level;
        
    }
    
    private void dfs(TreeNode root, int x, int y,TreeNode parent,int level)
    {
        if(root==null) return;
        
        if(root.val==x)
        {
            x_level=level+1;
            x_parent=parent;
        }
        
        if(root.val==y) 
        {
            y_level=level+1;
            y_parent=parent;
        }
        
        if(x_parent==null || y_parent==null)
            dfs(root.left,x,y,root,level+1);
        if(x_parent==null || y_parent==null)
            dfs(root.right,x,y,root,level+1);
        
    }
}

// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no