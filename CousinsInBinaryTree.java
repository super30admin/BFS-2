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

    int xDepth;
    int yDepth;
    TreeNode xParent;
    TreeNode yParent;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        dfs(root, null, 0, x, y);
        return xParent != yParent && xDepth == yDepth;
    }

    public void dfs(TreeNode root, TreeNode parent, int depth, int x, int y) {

        if (root == null) {
            return;
        }

        if (root.val == x) {
            xParent = parent;
            xDepth = depth;
        }

        if (root.val == y) {
            yParent = parent;
            yDepth = depth;
        }

        dfs(root.left, root, depth + 1, x, y);
        dfs(root.right, root, depth + 1, x, y);
    }
}