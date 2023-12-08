// Time Complexity : O(n)
// Space Complexity : O(D) diameter of the tree. N/2 in case of worstacse 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Problem2 {
    TreeNode parentX = null;
    TreeNode parentY = null;
    boolean xFound = false;
    boolean yFound = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {

                TreeNode temp = q.poll();

                if (temp.val == x) {
                    xFound = true;
                }
                if (temp.val == y) {
                    yFound = true;
                }

                if (temp.left != null && temp.right != null) {
                    if (temp.left.val == x && temp.right.val == y)
                        return false;
                    if (temp.left.val == y && temp.right.val == x)
                        return false;
                }

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

            if (xFound && yFound)
                return true;
            if (xFound || yFound)
                return false;
        }
        return false;
    }

    public static void main(String[] args) {
        // Example Usage
        // Create a simple binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Problem2 solution = new Problem2();
        int x = 4;
        int y = 5;
        boolean result = solution.isCousins(root, x, y);

        // Print the result
        System.out.println("Are " + x + " and " + y + " cousins? " + result);
    }
}
