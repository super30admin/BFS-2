// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
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

class Solution {
    // DFS O(n) O(h)

    // private TreeNode xP;
    // private TreeNode yP;
    // private int xD;
    // private int yD;
    // public boolean isCousins(TreeNode root, int x, int y) {
    // if (root == null)
    // return false;
    // dfs(root, x, y, 0, null);
    // return xD == yD && xP != yP;
    // }

    // private void dfs(TreeNode root, int x, int y, int level, TreeNode parent) {
    // if (root == null)
    // return;

    // if (x == root.val) {
    // xP = parent;
    // xD = level;
    // }
    // if (y == root.val) {
    // yP = parent;
    // yD = level;
    // }

    // dfs(root.left, x, y, level + 1, root);
    // dfs(root.right, x, y, level + 1, root);
    // }

    //BFS
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> pq = new LinkedList<>();
        q.add(root);
        pq.add(null);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode xp = null;
            TreeNode yp = null;
            boolean xFound = false;
            boolean yFound = false;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                TreeNode currP = pq.poll();
                if (x == curr.val) {
                    xFound = true;
                    xp = currP;
                }
                if (y == curr.val) {
                    yFound = true;
                    yp = currP;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                    pq.add(curr);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    pq.add(curr);
                }
            }
            if (xFound && yFound)
                return xp != yp;
            if (xFound || yFound)
                return false;

        }
        return false;
    }
}