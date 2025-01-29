import java.util.LinkedList;
import java.util.Queue;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * - Check if parent has both given child as siblings, return false
 * - If the current node is either of the child, set child_x/child_y found
 * - If both child are found at same level but parents are not same - it is a cousin
 * - Otherwise they are not found
 */

public class CousinsInBinaryTree {
    public static class TreeNode {

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
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean xFound = false;
        boolean yFound = false;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x || curr.left.val == y) && (curr.right.val == x || curr.right.val == y)) {
                        return false;
                    }
                }

                if (curr.val == x) {
                    xFound = true;
                }
                if (curr.val == y) {
                    yFound = true;
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            if (xFound && yFound) {
                return true;
            }

            if (xFound || yFound) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        // Your code here
    }
}