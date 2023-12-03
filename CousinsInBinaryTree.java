// Time complexity : O(n)
// Space complexity : O(n)

import java.util.*;

class TreeNode {
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

public class CousinsInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        int x = 5;
        int y = 4;
        boolean result = isCousins(root, x, y);
        System.out.println(result);
    }

    private static boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean x_found = false;
            boolean y_found = false;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.val == x)
                    x_found = true;
                if (curr.val == y)
                    y_found = true;
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y)
                        return false;
                    if (curr.left.val == y && curr.right.val == x)
                        return false;
                }
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            if (x_found && y_found)
                return true;
            if (x_found || y_found)
                return false;
        }
        return false;
    }

}
