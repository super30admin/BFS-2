// TC : O(N)
// SC: O(H)
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
// Resursive
class Solution {

    TreeNode xParent, yParent;
    int xLvl, yLvl;
    public boolean isCousins(TreeNode root, int x, int y) {
        // base case
        if (root == null) return false;

        dfs(null, x, y, root, 0);

        return (xLvl == yLvl && xParent != yParent);
    }

    private void dfs(TreeNode parent, int x, int y, TreeNode root, int level) {
        // base case
        if (root == null) return;
        // check if value matches x
        if(root.val == x) {
            xParent = parent;
            xLvl  = level;
        }

        // check if value matches y
        if (root.val == y) {
            yParent = parent;
            yLvl = level;
        }

        // recursive cases
        if (xParent ==null || yParent == null) {
            dfs(root, x, y, root.left, level+1);
            dfs(root, x, y, root.right, level+1);
        }


    }
}
