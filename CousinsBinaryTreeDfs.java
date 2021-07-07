// Time Complexity : O(n)
// Space Complexity : O(h)

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
    int x_level;
    int y_level;
    TreeNode x_parent;
    TreeNode y_parent;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, x, y);
        return x_level == y_level && x_parent != y_parent;
    }
    
    private void dfs(TreeNode root, int level, int x, int y){
        //base
        if(root == null)
            return;
        //logic
        if(root.left != null && root.left.val == x){
            x_parent = root;
            x_level = level + 1;
        }
        if(root.right != null && root.right.val == x){
            x_parent = root;
            x_level = level + 1;
        }
        if(root.left != null && root.left.val == y){
            y_parent = root;
            y_level = level + 1;
        }
        if(root.right != null && root.right.val == y){
            y_parent = root;
            y_level = level + 1;
        }
        if(x_parent != null && y_parent != null)
            return;
        dfs(root.left, level + 1, x, y);
        dfs(root.right, level + 1, x, y);
    }
}