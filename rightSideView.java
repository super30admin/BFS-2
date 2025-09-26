// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result, int level){

        if(root == null) return;

        if(result.size() == level){
            result.add(root.val);
        }

        helper(root.right, result, level+1);
        helper(root.left, result, level+1);
    }
}
