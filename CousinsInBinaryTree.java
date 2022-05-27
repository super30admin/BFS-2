/**
Time Complexity : O(N), N = count of elements
Space Complexity : O(D), D = depth of the element
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class Solution 
{
    int parent_x = -1;
    int parent_y = -1;
    
    int level_x = -1;
    int level_y = -1;
    
    
    
    public boolean isCousins(TreeNode root, int x, int y) 
    {   
        traverse(root, x, y, 0, null);
        
        return ((level_x == level_y) && (parent_x != parent_y));
    }
    
    public void traverse(TreeNode root, int x , int y, int level, TreeNode parent)
    {
        if(root == null)
            return;
        
        if(root.val == x)
        {
            if(parent != null)
            {
                parent_x = parent.val;
                level_x = level;
            }
            
        }
        else if(root.val == y)
        {
            if(parent != null)
            {
                parent_y = parent.val;
                level_y = level;
            }
        }
        
        if(root.left != null)
            traverse(root.left, x,y, level + 1, root);
        
        if(root.right != null)
            traverse(root.right, x, y, level + 1, root);

    }
}