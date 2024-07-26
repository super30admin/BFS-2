/**
 * Time Complexity (TC): O(n) - n : no.of nodes in the binary tree
 * Space Complexity (SC): O(n)
 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null)
            return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean xFound = false;
            boolean yFound = false;

            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();

                if (temp.val == x)
                    xFound = true;
                if (temp.val == y)
                    yFound = true;

                if (temp.left != null && temp.right != null) {
                    if ((temp.left.val == x && temp.right.val == y) || (temp.left.val == y && temp.right.val == x))
                        return false; // Same parent
                }

                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);
            }

            if (xFound && yFound)
                return true;

            if (xFound || yFound)
                return false;
        }

        return false;
    }
}
