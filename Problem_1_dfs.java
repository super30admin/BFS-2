// Time complexity - O(n)
// Space complexity - O(h)

// DFS


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
    TreeNode x_parent;
    TreeNode y_parent;
    int x_depth; int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        
        dfs(root,null,0,x,y);
        return x_depth == y_depth && x_parent != y_parent;
    }
    
    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y){
        // base
        if(root == null){
            return;
        }
        
        // logic
        if(root.val == x){
            x_parent = parent;
            x_depth = level;
        }
        if(root.val == y){
            y_parent = parent;
            y_depth = level;
        }
        
        dfs(root.left,root,level+1,x,y);
        dfs(root.right,root,level+1,x,y);
    }
    
}
