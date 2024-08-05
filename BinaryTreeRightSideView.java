// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
    ArrayList<Integer> result = new ArrayList<>();
    private void helper(TreeNode root, int level){
        if(root==null) return;
        if(result.size()<=level) result.add(level, root.val);
        helper(root.right, level+1);
        helper(root.left, level+1);
        return;
    }
    public List<Integer> rightSideView(TreeNode root) {
        helper(root,0);
        return result;
    }
}
