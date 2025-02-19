// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
level order traversal and keep track if the node has been seen and keep track of the parent
 */

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
        Queue<TreeNode> child = new LinkedList<>();
        Queue<TreeNode> parent = new LinkedList<>();

        child.add(root);
        parent.add(null);

        while (!child.isEmpty()) {
            boolean x_found=false;
            boolean y_found=false;
            TreeNode x_parent=null;
            TreeNode y_parent=null;
            int size = child.size();
            for (int i = 0; i < size; i++) {
                TreeNode c = child.poll();
                TreeNode p = parent.poll();
                if (c.val == x) {
                    x_found = true;
                    x_parent = p;
                }
                if (c.val == y) {
                    y_found = true;
                    y_parent = p;
                }

                if (c.right != null) {
                    child.add(c.right);
                    parent.add(c);
                }

                if (c.left != null) {
                    child.add(c.left);
                    parent.add(c);
                }
            }

            if (x_found && y_found && x_parent != y_parent)
                return true;
        }

        return false;

    }
}
