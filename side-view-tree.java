// Time Complexity : O(n)  n=no of elements in tree.
// Space Complexity :O(1)   
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root,0);
        
        return result;
        
    }
    
    public void helper(TreeNode root,int level)
    {
        //base 
        if(root==null){return;}
        
        if(result.size()==level)
        {
            result.add(level, root.val);
        }
        helper(root.right, level+1);
        helper(root.left, level+1);
        
        
        
    }
}