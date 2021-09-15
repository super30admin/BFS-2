// Time Complexity : O(n) no of nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : took almost one hour to get to the solution


// Your code here along with comments explaining your approach
1. using DFS
2. if size of rightSide(result) Array == level it means this is the first element of that level to be added in result (from right).or we can say that belonging to this level there is no element in the result array yet.



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
        
        helper(root.right,level+1);
        helper(root.left,level+1);
    }
}
