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
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 */
class Solution {
    int x_lvl, y_lvl;
    TreeNode x_parent, y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || x == y ) return false;
        
        dfs(root, x, y, null, 0);
            
        return x_parent != y_parent && x_lvl == y_lvl;
    }
    
    private void dfs(TreeNode root, int x, int y, TreeNode parent, int lvl){
        if(root == null) return;
        
        if(x_parent == null || y_parent == null){
            dfs(root.left, x, y, root, lvl + 1);
        }
        
        if(x_parent == null || y_parent == null){
            dfs(root.right, x, y, root, lvl + 1);
        }
        
        if(x == root.val){
            x_parent = parent;
            x_lvl = lvl;
        }
        
        if(y == root.val){
            y_parent = parent;
            y_lvl = lvl;
        }
    }
}