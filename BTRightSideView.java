// Time Complexity : O(n) no. of elements in tree
// Space Complexity : O(h) height for the recursive call
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) new ArrayList<>();

        result = new ArrayList<>();

        dfs(root, 0);

        return result;

    }

    private void dfs(TreeNode root, int lvl){
        //base
        if(root == null) return;

        //logic
        if(lvl == result.size()) {
            result.add(root.val);
        }

        dfs(root.right, lvl+1);
        dfs(root.left, lvl+1);
    }
}