// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {


        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int xlevel = -1, ylevel = -2, level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();


            while (size > 0) {
                root = queue.poll();

                if (root.val == x) xlevel = level;
                if (root.val == y) ylevel = level;
                //check children equal to x or y then children are siblings return false
                if (root.left != null && root.right != null) {
                    if (root.left.val == x && root.right.val == y) return false;
                    if (root.left.val == y && root.right.val == x) return false;
                }
                if (root.left != null)
                    queue.add(root.left);
                if (root.right != null)
                    queue.add(root.right);
                size--;

            }
            level++;


        }
        return xlevel == ylevel;
    }
}