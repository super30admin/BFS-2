// Time Complexity : O(n) where n is the number of nodes, since we look at each node once
// Space Complexity :O(h) where h is the height of the recursion tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/**
 * Here we keep a global variable for parent and pos(that is the level) for x as
 * well as y (intially all as -1)
 * 
 * 
 * here we go in a dfs fashion, recursively, after the base conditions, we check
 * if left child is present and is equal to x or y (then update x_parent/
 * y_parent x_pos/y_pos) similarly for the right child
 * 
 * in the main function we see if x_parent!=y_parent and x_pos==y_pos and that
 * any of them is not -1 then return true
 * 
 * This code works because we know there are ony unique values
 */

class Solution {
    int x_parent = -1;
    int y_parent = -1;
    int x_pos = -1, y_pos = -1;

    public boolean isCousins(TreeNode root, int x, int y) {

        helper(root, x, y, 0);
        if (x_parent != y_parent && x > -1 && y > -1 && x_pos == y_pos)
            return true;
        return false;
    }

    private void helper(TreeNode root, int x, int y, int level) {

        if (root == null)
            return;

        if (root.left != null) {
            if (root.left.val == x) {
                x_pos = level + 1;
                x_parent = root.val;
            } else if (root.left.val == y) {
                y_pos = level + 1;
                y_parent = root.val;
            }
            helper(root.left, x, y, level + 1);
        }
        if (root.right != null) {
            if (root.right.val == x) {
                x_pos = level + 1;
                x_parent = root.val;
            } else if (root.right.val == y) {
                y_pos = level + 1;
                y_parent = root.val;
            }
            helper(root.right, x, y, level + 1);
        }

    }

}

// /////////////// ///
// ALternatively we can have another parameter known as parent where in the
// recursion of left and right child we pass the current node as parent