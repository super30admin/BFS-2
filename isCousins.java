public class isCousins {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        // return isCousinsBFSWithParentQueue(root, x, y);
        return isCousinsBFSWithoutParentQueue(root, x, y);
        // return isCousinsDFS(root, x, y);
    }

    // TC: O(N) where N is number of nodes
    // SC: O(N) where N is number of nodes
    private boolean isCousinsBFSWithParentQueue(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> parentQueue = new LinkedList<>();
        queue.add(root);
        parentQueue.add(null);
        boolean xFound = false, yFound = false;
        TreeNode xParent = null, yParent = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                TreeNode currParent = parentQueue.poll();
                if (curr.val == x) {
                    xFound = true;
                    xParent = currParent;
                }
                if (curr.val == y) {
                    yFound = true;
                    yParent = currParent;
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                    parentQueue.add(curr);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                    parentQueue.add(curr);
                }
            }
            if (xFound && yFound) return xParent != yParent;
            if (xFound || yFound) return false;
        }
        return true;
    }

    int xLevel = 0, yLevel = 0;
    TreeNode xParent = null, yParent = null;
    // TC: O(N) where N is number of nodes
    // SC: O(H) where H is height of tree
    private boolean isCousinsDFS(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, null);
        return xLevel == yLevel && xParent != yParent;
    }

    private void dfs(TreeNode root, int x, int y, int level, TreeNode parent) {
        if (root == null) return;
        if (root.val == x) {
            xLevel = level;
            xParent = parent;
        }
        if (root.val == y) {
            yLevel = level;
            yParent = parent;
        }
        dfs(root.left, x, y, level + 1, root);
        dfs(root.right, x, y, level + 1, root);
    }

    // TC: O(N) where N is number of nodes
    // SC: O(N) where N is number of nodes
    private boolean isCousinsBFSWithoutParentQueue(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean xFound = false, yFound = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.val == x) {
                    xFound = true;
                }
                if (curr.val == y) {
                    yFound = true;
                }
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y) return false;
                    if (curr.left.val == y && curr.right.val == x) return false;
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            if (xFound && yFound) return true;
            if (xFound || yFound) return false;
        }
        return true;
    }
}
