// Time Complexity : O(n) - where n is the number of nodes //While loop
// Space Complexity : O(2n) - ~ O(n) Where n is the number of nodes in given BT

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach:
/*
 * Keep adding node and its parent node (root) to queue (separate queue)
 * At every level check if node value matches to x or y
 * After every level is done see if both x and y found and their parents are different then true
 * If either of it found then false
 * if both foudn and then parent is same then false too
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

        if (root == null)
            return false;

        //BFS with 2 QUEUEs
        
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> pq = new LinkedList<>();

        int x_depth;
        int y_depth;

        q.add(root);
        pq.add(null);
        int size = 0;

        while (!q.isEmpty()) {
            size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            TreeNode x_parent = null;
            TreeNode y_parent = null;

            while (size > 0) {
                TreeNode child = q.poll();
                TreeNode parent = pq.poll();

                if (child.val == x) {
                    x_parent = parent;
                    x_found = true;
                }

                if (child.val == y) {
                    y_parent = parent;
                    y_found = true;
                }

                if (child.left != null) {
                    q.add(child.left);
                    pq.add(child);
                }

                if (child.right != null) {
                    q.add(child.right);
                    pq.add(child);
                }
                size--;
            }

            if (x_found && y_found && (x_parent != y_parent)) {
                return true;
            }
            if (x_found || y_found)
                return false;
        }
        return false;
    }

}