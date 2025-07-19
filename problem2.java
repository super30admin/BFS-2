// Time Complexity: O(n)
// Space Complexity: O(H)

// We iterate the tree DFS, and we maintain the parent and level if value is equal to x or y. After traversing, we check if parents are different and level is same.

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
class Solution {
    TreeNode x_parent, y_parent;
    int x_lvl, y_lvl;
    public boolean isCousins(TreeNode root, int x, int y) {
        isCousinsHelper(root, x, y, null, 0);
        if ((x_parent!=null && y_parent!=null && x_parent != y_parent) && (x_lvl == y_lvl)) return true;
        else return false;
    }

    public void isCousinsHelper(TreeNode root, int x, int y, TreeNode parent, int lvl) {
        if (root == null) return;
        
        if (root.val == x) {
            x_parent = parent;
            x_lvl = lvl;
        }
        if (root.val == y) {
            y_parent = parent;
            y_lvl = lvl;
        }

        isCousinsHelper(root.left, x, y, root, lvl + 1);
        isCousinsHelper(root.right, x, y, root, lvl + 1);
    }
}
