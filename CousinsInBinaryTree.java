// Time Complexity : O(n) where n is the number of nodes in the list
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.*;

public class CousinsInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    boolean x_found, y_found;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            x_found = false;
            y_found = false;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (x == curr.val)
                    x_found = true;
                if (y == curr.val)
                    y_found = true;
                if (curr.left != null && curr.right != null) {
                    if (x == curr.left.val && y == curr.right.val)
                        return false;
                    if (y == curr.left.val && x == curr.right.val)
                        return false;
                }
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            if (x_found && y_found)
                return true;
            if (x_found || y_found)
                return false;
        }
        return true;
    }
}
