// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.*;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node.val == x) {
                    foundX = true;
                }
                if (node.val == y) {
                    foundY = true;
                }

                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) ||
                            (node.left.val == y && node.right.val == x)) {
                        return false; // Same parent, not cousins
                    }
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (foundX && foundY) {
                return true; // Found both nodes at the same level, they are cousins
            }
            if (foundX || foundY) {
                return false; // Found only one node, they can't be cousins
            }
        }

        return false; // Didn't find both nodes, they can't be cousins
    }
}
