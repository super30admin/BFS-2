// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> qParent = new LinkedList<>();

        q.add(root);
        qParent.add(null);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean isxFound = false;
            boolean isyFound = false;
            TreeNode xParent = null;
            TreeNode yParent = null;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                TreeNode parent = qParent.poll();
                if (curr.val == x) {
                    isxFound = true;
                    xParent = parent;
                }
                if (curr.val == y) {
                    isyFound = true;
                    yParent = parent;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                    qParent.add(curr);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    qParent.add(curr);
                }
            }
            if (isxFound && isyFound && xParent != yParent) {
                return true;
            }
            if (isxFound || isyFound || xParent != yParent) {
                return false;
            }
        }
        return false;
    }
}
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

// ------------Using 1 Queue-------------------

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            boolean xFound = false;
            boolean yFound = false;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.val == x)
                    xFound = true;
                if (curr.val == y)
                    yFound = true;
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y)
                        return false;
                    if (curr.left.val == y && curr.right.val == x)
                        return false;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (xFound && yFound)
                return true;
            if (xFound || yFound)
                return false;
        }
        return false;
    }
}
// ----------------DFS--------------------------
// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    private int xdep;
    private int ydep;
    private TreeNode xParent;
    private TreeNode yParent;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return true;
        dfs(root, x, y, 0, null);
        return (xdep == ydep && xParent != yParent);
    }

    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        // edge
        if (root == null)
            return;
        if (root.val == x) {
            xdep = depth;
            xParent = parent;
        }
        if (root.val == y) {
            ydep = depth;
            yParent = parent;
        }
        // logic
        dfs(root.left, x, y, depth + 1, root);
        dfs(root.right, x, y, depth + 1, root);
    }
}
