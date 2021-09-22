// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // intialize the return list
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        // call the recursive function
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        //base
        // if leaf node in hit then return
        if(root == null) return;
        // logic
        // if level does not exist then add node's value to the list
        if(result.size() == level) result.add(root.val);
        // call recursive function on the right child node first
        dfs(root.right, level + 1);
        // then call recursive function on the left child node
        dfs(root.left, level + 1);
    }
}