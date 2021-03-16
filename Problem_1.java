// Time Complexity : O(n), no. of nodes in tree 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return result;
    }
    public void helper(TreeNode root, int level){
        if(root == null)
            return;
        if(result.size() == level) // level = 2, root = 4
            result.add(root.val);
        else
            result.set(level, root.val);
        
        helper(root.left, level +1);
        helper(root.right, level +1);
    }
}
