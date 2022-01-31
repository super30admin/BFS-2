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

//T.C - O(n)
//S.C - O(h), h-height of the tree

class Solution {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_height;
    int y_height;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        
        dfs(root, null, 0, x, y);
        
        return(x_parent!=y_parent && x_height==y_height);
    }
    
    private void dfs(TreeNode root, TreeNode parent, int height, int x, int y){
        //base
        if(root == null)
            return; 
            
        //logic
        if(root.val == x){
            x_parent = parent;
            x_height = height;
        }
        
        if(root.val == y){
            y_parent = parent;
            y_height = height;
        }
        
        dfs(root.left, root, height+1, x, y);
        dfs(root.right, root, height+1, x, y);
    }
}
