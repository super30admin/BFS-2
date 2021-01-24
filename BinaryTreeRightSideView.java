/**

Leetcode: Binary Tree Right Side View 
https://leetcode.com/problems/binary-tree-right-side-view/

Given a binary tree, imagine yourself standing on the right side of it, 
return the values of the nodes you can see ordered from top to bottom.


Collabedit: http://collabedit.com/yhbjt

Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


**/
class Solution 
{
    
    public List<Integer> rightSideView1(TreeNode root) 
    {
        List<Integer> output = new ArrayList<>();
        
        TreeNode current = null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while( !queue.isEmpty() )
        {
            int size = queue.size();
            
            for( int i =0 ;i < size; i++)
            {
                current = queue.poll();
                
                if( current.left != null) queue.add( current.left);
                
                if( current.right != null) queue.add( current.right);
            
            }
            
            output.add( current.val); 
        }
        
        return output;
        
    }
    
    
    private List<Integer> output2 = new ArrayList<>();
    
    public List<Integer> rightSideView2(TreeNode root)
    {
        dfs( root, 0);
        
        return output2;
    }
    
    private void dfs(TreeNode root, int level)
    {
        if( root == null) return;
        
        if( output2.size() == level)
        {
            // add that element to the ouput
            
            output2.add( root.val);
        
        }
        
        if( root.right != null)
            dfs( root.right, level + 1);
            
        if( root.left != null)
            dfs( root.left, level + 1);
    
    }
}
