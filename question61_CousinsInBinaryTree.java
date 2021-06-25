package BFS2;

import java.util.LinkedList;
import java.util.Queue;

public class question61_CousinsInBinaryTree {
    /* Created by palak on 6/23/2021 */

    /**
     * Definition for a binary tree node.
     */
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

    /*
        Time Complexity: O(n)
        Space Complexity: O(n) -> width of the tree
    */
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) return false;
        dfs(root, null, 0, x, y);
        return x_parent != y_parent && x_depth == y_depth;
    }

    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y) {
        //Base
        if (root == null) return;
        //Logic
        if (root.val == x) {
            x_depth = depth;
            x_parent = parent;
        }
        if (root.val == y) {
            y_depth = depth;
            y_parent = parent;
        }
        dfs(root.left, root, depth + 1, x, y);
        dfs(root.right, root, depth + 1, x, y);

    }


    /*
            Time Complexity: O(n)
            Space Complexity: O(n) -> width of the tree
        */
    public boolean isCousinsBFS(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean x_found = false;
            boolean y_found = false;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.val == x) x_found = true;
                if (temp.val == y) y_found = true;

                if (temp.left != null && temp.right != null) {
                    if (temp.left.val == x && temp.right.val == y) return false;
                    if (temp.left.val == y && temp.right.val == x) return false;
                }
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            if (x_found && y_found) return true;
            // if(x_found || y_found) return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}