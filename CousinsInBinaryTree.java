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
 //  Time O(n)
 // Space : O(h)
class Solution {
    TreeNode x_parent, y_parent;
    int x_level, y_level;
    public boolean isCousins(TreeNode root, int x, int y) {
     dfs(root,null,0,x,y);
     return x_parent!=y_parent && x_level==y_level ;   
    }
    
    public void dfs(TreeNode root, TreeNode parent, int level, int x , int y)
    {   if(root==null) return;
       if(root.val==x)
       {
           x_level=level; x_parent = parent;
       }
        else if(root.val==y)
        {
            y_level=level; y_parent = parent;
        }
     dfs(root.left,root, level+1,x,y);
     dfs(root.right,root,level+1,x,y);
            
        
        
        
    }
}