// Time Complexity : O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

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

    //we maintain the level and parents of both and then search for them in tree
    //then we compare both things

    TreeNode x_parent;
    TreeNode y_parent;
    int x_level;
    int y_level;

    public boolean isCousins(TreeNode root, int x, int y) {

        dfs(root, x, y, 0, null);
        return x_parent != y_parent && x_level == y_level;
    }

    private void dfs (TreeNode root, int x, int y, int level, TreeNode parent)
    {
        //base
        if(root == null)
            return;

        dfs(root.left, x, y, level+1, root);

        if(root.val == x)
        {
            x_parent = parent;
            x_level = level;
        }

        if(root.val == y)
        {
            y_parent = parent;
            y_level = level;
        }

        dfs(root.right, x, y, level+1, root);
    }
}
