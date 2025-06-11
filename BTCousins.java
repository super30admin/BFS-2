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
    Queue<TreeNode> pq = new LinkedList<TreeNode>();
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    TreeNode x_parent = null;
    TreeNode y_parent = null;
    boolean xFound = false;
    boolean yFound = false;
    int x_level = -1;
    int y_level = -1;
    int level = 1;

    public boolean isCousins(TreeNode root, int x, int y) {
        q.add(root);
        pq.add(null);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                TreeNode currParent = pq.poll();

                if (curr.val == x) {
                    x_parent = currParent;
                    xFound = true;
                    x_level = level;
                } else if (curr.val == y) {
                    y_parent = currParent;
                    yFound = true;
                    y_level = level;
                }

                if (curr.right != null) {
                    q.add(curr.right);
                    pq.add(curr);
                }

                if (curr.left != null) {
                    q.add(curr.left);
                    pq.add(curr);
                }
            }
            level++;
        }

        if (xFound && yFound && x_level == y_level) {
            return !(x_parent.val == y_parent.val);
        } else {
            return false;
        }
    }

}