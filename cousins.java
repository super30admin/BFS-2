//BFS
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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

class Main {
    // BFS
    public static boolean isCousins(TreeNode root, int x, int y) {
        // null case
        if (root == null)
            return true;
        // Queue for BFS
        Deque<TreeNode> q = new ArrayDeque<TreeNode>();
        // add q in the list
        q.add(root);
        // bfs traversal
        while (!q.isEmpty()) {
            // size for maintaining the level
            int size = q.size();
            // for checking that both elements are at the same level or not
            boolean xFlag = false;
            boolean yFlag = false;
            for (int i = 0; i < size; i++) {
                // get current node from the queue
                TreeNode cur = q.poll();
                // if we found our element at particular index we make our flag
                if (cur.val == x)
                    xFlag = true;
                if (cur.val == y)
                    yFlag = true;
                // here I am checking that at current index both the child of it are our desired
                // element or not
                // if yes we return false;
                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == x && cur.right.val == y)
                        return false;
                    if (cur.left.val == y && cur.right.val == x)
                        return false;
                }
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
            }
            // System.out.println(xFlag + " " + yFlag);
            // if both element found at same level we return true;
            if (xFlag && yFlag)
                return true;
            // if only one element found than we return false;
            if (xFlag || yFlag)
                return false;
        }
        return false;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        int x = 5;
        int y = 4;
        System.out.println(isCousins(root, x, y));

    }
}