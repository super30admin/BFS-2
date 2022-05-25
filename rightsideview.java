// Time Complexity :O(h) - height of tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }
    
    private void dfs(TreeNode root, List<Integer> result, int depth){
        if(root==null){
            return;
        }
        if(depth == result.size()){//if depth is same and size - you can add the root val
            result.add(root.val);
        }
        //we update the depth for every loop - hence we do right first to add it
        dfs(root.right, result, depth+1);
        dfs(root.left, result, depth+1);
    }
}