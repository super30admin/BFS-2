class Solution {

    TreeNode parentx = null, parenty = null;
    int levelx = -1, levely = -1;

    public boolean isCousins(TreeNode root, int x, int y) {
        parentx = null;
        parenty = null;

        levelx = -1;
        levely = -1;

        solve(root, null, 0, x, y);

        if (parentx == parenty) {
            return false;
        } else if (levelx != levely || levelx == -1 || levely == -1) {
            return false;
        } else {
            return true;
        }

    }

    public void solve(TreeNode root, TreeNode parent, int k, int x, int y) {
        if (root == null) {
            return;
        }

        if (root.val == x) {
            parentx = parent;
            levelx = k;
            return;
        }

        if (root.val == y) {
            parenty = parent;
            levely = k;
            return;
        }
        solve(root.left, root, k + 1, x, y);
        solve(root.right, root, k + 1, x, y);
    }
}