// Time complexity: O(n)
// Space complexity: O(h)

//Approach: Find both items and check if their parents are different and heights are equal

class CousinsInBinaryTree {
    TreeNode xParent;
    TreeNode yParent;
    int xHeight;
    int yHeight;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, x, y, 0);
        if (xHeight == yHeight && xParent != yParent) {
            return true;
        }
        return false;
    }

    public void dfs(TreeNode node, TreeNode parent, int x, int y, int height) {
        if (node == null || (xHeight != 0 && yHeight != 0)) {
            return;
        }

        if (node.val == x) {
            xHeight = height;
            xParent = parent;
        }

        if (node.val == y) {
            yHeight = height;
            yParent = parent;
        }

        dfs(node.left, node, x, y, height + 1);
        dfs(node.right, node, x, y, height + 1);
    }
}