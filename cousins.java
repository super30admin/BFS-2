
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
 * Tc --> O(n)
 * Sc --> O(1)
 */
class Solution {

    TreeNode parent_node_x = null;
    TreeNode parent_node_y = null;

    public boolean isCousins(TreeNode root, int x, int y) {

        int level1 = level(root, null, x, 0);
        int level2 = level(root, null, y, 0);

        if (level1 == level2 && parent_node_x != parent_node_y) {
            return true;
        }
        return false;

    }

    public int level(TreeNode root, TreeNode parent, int target, int l) {
        if (root != null) {
            if (root.val == target) {
                if (parent_node_x == null) {
                    parent_node_x = parent;
                } else {
                    parent_node_y = parent;
                }
                return l;
            }//if

            int left = level(root.left, root, target, l + 1);
            int right = level(root.right, root, target, l + 1);
            return left + right;
        }//if

        return 0;

    }//method
}//class
