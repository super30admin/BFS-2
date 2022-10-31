// Time Complexity : O(n) no. of elements in tree
// Space Complexity : O(h) height for the recursive call
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
    TreeNode x_parent, y_parent;
    int x_lvl, y_lvl;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || x == y) return false;

        dfs(root, x, y, null, 0);

        return x_parent != y_parent && x_lvl == y_lvl;
    }

    private void dfs(TreeNode root,int x, int y, TreeNode parent, int lvl){
        //base
        if(root == null) return;

        if(x == root.val){
            x_parent = parent;
            x_lvl = lvl;
        }
        if(y == root.val){
            y_parent = parent;
            y_lvl = lvl;
        }
        if(x_parent == null || y_parent == null)
            dfs(root.left, x, y, root, lvl+1);

        if(x_parent == null || y_parent == null)
            dfs(root.right, x, y, root, lvl+1);
    }
}