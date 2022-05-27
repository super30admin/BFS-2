/**
Time Complexity : O(N), N = count of elements
Space Complexity : O(D), D = depth of the element
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class Solution 
{
    private List<Integer> output;
    
    public List<Integer> rightSideView(TreeNode root) 
    {
        this.output = new ArrayList<>();
        inorder(root, 0);
        return this.output;
    }
    
    private void inorder(TreeNode root, int level)
    {
        if(root == null)
            return;
        
        if(level < output.size())
        {
            output.set(level, root.val);
        }
        else
        {
            output.add(root.val); 
        }
        
        if(root.left != null)
            inorder(root.left, level +1);
        
        if(root.right != null)
            inorder(root.right, level +1);
    }
}