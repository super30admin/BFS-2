// Time Complexity : O(n) no of nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : took almost one hour to get to the solution


// Your code here along with comments explaining your approach
1. using DFS (will read left node first and add in result array and then right
2. if size == level add node val to result
else update result index with new value.

class Solution {
    
    List<Integer> rightSide = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        
      helper(root,0);
        return rightSide;
    }
    
    private void helper(TreeNode root, int level)
    {
        if(root == null) return;
        
        if(rightSide.size() == level)
         rightSide.add(root.val);
        else
            rightSide.set(level,root.val);
        
         helper(root.left,level+1);
         helper(root.right,level+1);
       
        
        
    }
}