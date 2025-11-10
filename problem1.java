
// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
 * Approach
 * 
 * We are using the DFS approach where and we are starting for the left side
 * 
 * in the parameters we wll have root, height of the tree and result
 * 
 * height is used to keep track of elements inserted at eack level
 * 
 * logic here is keep on adding all the element because we started from the left 
 * if we encounter a new element at that level we will update the result with that value
 * and return the final result when we are done reversing all the nodes
 *
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode root, int height, List<Integer> result) {
        // base
        if (root == null)
            return;

        // logic
        if (height == result.size()) {
            result.add(root.val);
        } else {
            result.set(height, root.val);
        }

        // recursion
        dfs(root.left, height + 1, result);
        dfs(root.right, height + 1, result);
    }
}