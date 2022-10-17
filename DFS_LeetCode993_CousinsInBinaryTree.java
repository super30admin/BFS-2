/*this apporach will not work for in-order as node processing and level check will be done at different level  for both right and left */ 

//approach - dfs - save the parent for both x and y and 
//also traverse through levels and incement it and save it in xlvlv and ylvl. 
//TC - O(n) - number of nodes visited in tree. 
//sc - O(n) - recurive calls made geneartes recursive stacks  
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
   
    int x_level, y_level;
    TreeNode x_parent, y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null || x == y ) return false;
        
        x_level =0;
        y_level =0;
        
        dfs(root, x,y, null, 0);
        return x_level==y_level && x_parent != y_parent;
    }
    
    private void dfs(TreeNode root, int x, int y, TreeNode parent, int level)
    {
        //base case
       if(root == null) return;
        
        //logic
       
        
        if(x_parent == null || y_parent == null)
            dfs(root.left, x, y, root, level+1);

        if(x_parent == null || y_parent == null)
            dfs(root.right, x,y,root, level+1);
       
            //post-order
        if(root.val == x)
            {
                x_parent = parent;
                x_level = level;
            }
        if(root.val == y)
        {
            y_parent = parent;
            y_level = level;
        }
    }
}


//pre-order solution

class Solution {
   
    int x_level, y_level;
    TreeNode x_parent, y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null || x == y ) return false;
        
        x_level =0;
        y_level =0;
        
        dfs(root, x,y, null, 0);
        return x_level==y_level && x_parent != y_parent;
    }
    
    private void dfs(TreeNode root, int x, int y, TreeNode parent, int level)
    {
        //base case
       if(root == null) return;
        
        //logic
        //Pre-order
        if(root.val == x)
        {
            x_parent = parent;
            x_level = level;
        }
        if(root.val == y)
        {
            y_parent = parent;
            y_level = level;
        }
        
        if(x_parent == null || y_parent == null)
            dfs(root.left, x, y, root, level+1);

        if(x_parent == null || y_parent == null)
            dfs(root.right, x,y,root, level+1);
       
         
    }
}