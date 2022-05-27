/**
Time Complexity : O(N), N = count of elements
Space Complexity : O(D), D = depth of the element
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class Solution 
{
    public boolean isCousins(TreeNode root, int x, int y) 
    {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> parent = new LinkedList<>();
        
        queue.add(root);
        parent.add(null);
        
        int level = 0;
        
        int level_x = -1;
        int level_y = -1;
        int parent_x = -1;
        int parent_y = -1;
        
        
        while(!queue.isEmpty())
        {
            
            int size= queue.size();
            
            
            for(int i = 0; i< size ; i++)
            {
                TreeNode current = queue.poll();
                TreeNode parentCurrent = parent.poll();
                
                if(current.val == x)
                {
                    if(parentCurrent != null)
                    {
                        level_x = level;
                        parent_x = parentCurrent.val;
                    }
                }
                if(current.val == y)
                {
                    if(parentCurrent != null)
                    {
                        level_y = level;
                        parent_y = parentCurrent.val;                        
                    }
                }
                
                if(current.left != null)
                {
                    queue.add(current.left);
                    parent.add(current);
                    
                }
                if(current.right != null)
                {
                    queue.add(current.right);
                    parent.add(current);
                }
            }
            
            level++;
        }
        
        return ((level_x == level_y)&&(parent_x!=parent_y));
    }
}