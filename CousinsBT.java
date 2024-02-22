// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
import java.util.Queue;

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
    int x_depth;
    int y_depth;
    TreeNode x_parent = null;
    TreeNode y_parent = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        helperDfs(root, x, y, null, 0);
        return x_parent != y_parent && (x_depth == y_depth);

        // return helperBfs2Qs(root, x, y);
        // return helperBfs1Q(root, x, y);
    }

    private void helperDfs(TreeNode root, int x, int y, TreeNode parent, int level) {
        if (root == null) {
            return;
        }

        System.out.println(
                "root: " + root.val + "  parent: " + (parent == null ? null : parent.val) + "   level: " + level);
        if (root.val == x) {
            x_parent = parent;
            x_depth = level;
        }

        if (root.val == y) {
            y_parent = parent;
            y_depth = level;
        }

        if (x_parent != null && y_parent != null) {
            return;
        }
        helperDfs(root.left, x, y, root, level + 1);
        helperDfs(root.right, x, y, root, level + 1);
    }

    private boolean helperBfs2Qs(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> parentQueue = new LinkedList<>();

        queue.offer(root);
        parentQueue.offer(null);

        while (!queue.isEmpty()) {
            int size = queue.size();

            boolean xFound = false;
            boolean yFound = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode parent = parentQueue.poll();
                if (node.val == x) {
                    x_parent = parent;
                    xFound = true;
                }

                if (node.val == y) {
                    y_parent = parent;
                    yFound = true;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                    parentQueue.offer(node);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    parentQueue.offer(node);
                }
            }

            if (xFound && yFound && (x_parent != y_parent)) {
                return true;
            }
        }
        return false;
    }

    private boolean helperBfs1Q(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean xFound = false;
            boolean yFound = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.val == x) {
                    xFound = true;
                }

                if (node.val == y) {
                    yFound = true;
                }

                if (node.left != null && node.right != null) {
                    if (node.left.val == x && node.right.val == y) {
                        return false;
                    }

                    if (node.left.val == y && node.right.val == x) {
                        return false;
                    }
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (xFound && yFound) {
                return true;
            }
        }
        return false;
    }
}