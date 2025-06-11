// Time Complexity O(n)
// Space Complexity O(n)
// Runs on LeetCode YES
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
    ArrayList<Integer> result = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int level){
        if(root == null) return;

        if(result.size() == level){
            result.add(level, root.val);
        }

        helper(root.right, level+1);
        helper(root.left, level+1);
    }
}