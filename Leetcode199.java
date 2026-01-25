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
// Solution - PreOrder traversal and replace left elements with right most
// elements
// TC - O(n)
// SC - O(1) - ignoring output list
// class Solution {
// List<Integer> res;

// public List<Integer> rightSideView(TreeNode root) {
// this.res = new ArrayList<>();

// helper(root, 0);
// return res;
// }

// private void helper(TreeNode node, int level) {
// // Base
// if (node == null)
// return;

// // Logic
// if (level >= res.size()) {
// res.add(node.val);
// } else {
// res.set(level, node.val);
// }

// // Left
// helper(node.left, level + 1);

// // Right
// helper(node.right, level + 1);

// }
// }

// Solution 2- DFS Solution while adding only the last element of the queue at
// each level
// TC - O(n)
// SC - O(n) - Queue space
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return res;
        q.add(root);
        int size = q.size();
        while (!q.isEmpty()) {
            while (size != 0) {
                TreeNode node = q.poll();
                if (size == 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                size--;
            }
            size = q.size();
        }

        return res;
    }
}