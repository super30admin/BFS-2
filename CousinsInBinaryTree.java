/**

Leetcode: https://leetcode.com/problems/cousins-in-binary-tree/

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y 
of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

Collabedit: http://collabedit.com/72kek

Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/

class Solution 
{
    public boolean isCousins(TreeNode root, int x, int y) 
    {
        if( root == null ) return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add( root);
        

        
        while( !queue.isEmpty() )
        {
            int size = queue.size();
            
            boolean found_x = false;
            boolean found_y = false;
            
            for( int i =0 ;i < size; i++)
            {
                TreeNode current = queue.poll();
                
                if( current.left != null && current.right != null)
                {
                    if(( current.left.val == x && current.right.val == y) || ( current.right.val == x && current.left.val == y) )  return false;
                }
                
                if( current.val == x) found_x = true;
                if( current.val == y) found_y = true;
                
                if( current.left != null) queue.add( current.left);
                if( current.right != null) queue.add( current.right);
            }
            
            if( found_x && found_y) return true;
            
        }
        
        return false;
        
    }
    
    private boolean found_x = false;
    private boolean found_y = false;
    private TreeNode parent_x;
    private TreeNode parent_y;
    private int level_x ;
    private int level_y;
 
    
    
    public boolean isCousins2(TreeNode root, int x, int y)
    {
        dfs(root, null, 0, x, y);
        
        if(found_x && found_y)
        {
            if( parent_x == parent_y) return false;
            
            if( level_x == level_y) return true;
            
            return false;
        }
        else
        {
            return false;
        }
    }
    
    
    public void dfs(TreeNode root, TreeNode parent, int level, int x, int y)
    {
        if(root == null) return;
        
        if(root.val == x)
        {
            found_x = true;
            parent_x = parent;
            level_x = level;
        }
        
        if( root.val == y)
        {
            found_y = true;
            parent_y = parent;
            level_y = level;
        }
        
        dfs( root.left, root, level + 1, x, y);
        dfs( root.right, root, level + 1, x, y);
    }
    
    
    
    
}










