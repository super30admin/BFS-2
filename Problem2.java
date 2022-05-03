import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
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

    //    TC : O(n)
    //    Sc : O(n)
    // BFS
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || x == y) return false;

        Queue<TreeNode> que = new LinkedList<>();
        int level = 0;
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            boolean x_found = false;
            boolean y_found = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();
                if (curr.val == x) {
                    x_found = true;
                }
                if (curr.val == y) {
                    y_found = true;
                }
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y) {
                        return false;
                    }
                    if (curr.left.val == y && curr.right.val == x) {
                        return false;
                    }
                }
                if (curr.left != null) {
                    que.add(curr.left);
                }
                if (curr.right != null) {
                    que.add(curr.right);
                }

            }
            if (x_found && y_found) return true;
            if (x_found || y_found) return false;
        }
        return false;
    }


    private int x_lvl, y_lvl;
    private TreeNode x_parent, y_parent;

    //    TC : O(n)
    //    Sc : O(n)
    // DFS

    public boolean isCousins1(TreeNode root, int x, int y) {
        if (root == null || x == y) return false;

        helper(root, x, y, 0, null);
        //post operation outside recusrion call
        return x_lvl == y_lvl && x_parent != y_parent;
    }

    private void helper(TreeNode root, int x, int y, int lvl, TreeNode parent) {
        //base case
        if (root == null) return;
        //logic
        if (root.val == x) {
            x_lvl = lvl;
            x_parent = parent;
        }
        if (root.val == y) {
            y_lvl = lvl;
            y_parent = parent;
        }
        if (x_parent == null || y_parent == null) {
            helper(root.left, x, y, lvl + 1, root);
            helper(root.right, x, y, lvl + 1, root);
        }
    }

}
