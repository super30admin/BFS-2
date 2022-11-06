/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// time complexity = O(n)
// Space complexity = O(n)
class Solution {

    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();

        rightSideView(root, 0);

        return result;
    }

    private void rightSideView(TreeNode root, int level) {

        if (root == null) {
            return;
        }

        if (result.size() == level) {
            result.add(root.val);
        }

        rightSideView(root.right, level + 1);
        rightSideView(root.left, level + 1);

    }
}