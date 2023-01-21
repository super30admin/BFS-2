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

 // Time Complexity = 
 // Space Complexity = 
 // DFS

class Solution {
    TreeNode parentX;
    TreeNode parentY;
    int depthX;
    int depthY;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, x, y, 0, null);
        return parentX != parentY && depthX == depthY;
    }
    
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent){
        //
        if (root==null) return;
        
        //
        if(root.val == x){
            parentX = parent;
            depthX = depth;
        }
        if(root.val == y){
            parentY = parent;
            depthY = depth;
        }
        
        dfs(root.left, x, y, depth+1, root);
        dfs(root.right, x, y, depth+1, root);
        
    }
}