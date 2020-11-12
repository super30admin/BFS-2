package Nov11;

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
class CousinsInBinaryTreeDFS {
    
/*
     Time Complexity: O(n)
     Since in worst case scenario, we will iterate through all n nodes of the tree to find nodes with x and y.
    
     Space Complexity: O(h) 
     At max, the recursive stack will have h nodes where h is height of the tree 
   
     Did this code successfully run on Leetcode : Yes
    
     Any problem you faced while coding this : No
        
     Approach: 
     DFS used to traverse the given tree till nodes with both x and y values found. 
     Then level and parents of nodes with value as x and y are compared to decide if the given nodes are cousins or not.
               
*/ 
    
    TreeNode x_parent, y_parent;
    int x_depth, y_depth;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        dfs(root, x, y, 0, null);
        
        // x and y nodes will be cousins if they are at the same level and having different parents. 
        if (x_parent != y_parent && x_depth == y_depth) {
            return true;
        }
        
        return false;
        
    }
    
    // Helper funct: Recursive function for performing dfs on given tree
    public void dfs(TreeNode root, int x, int y, int level, TreeNode parent) {
        
        // base condition
        if (root == null) {
            return;
        } 
        
        // logic
        if (root.val == x) {
            x_parent = parent; 
            x_depth = level;
        }
        
        if (root.val == y) {
            y_parent = parent; 
            y_depth = level;
        }
        
        // both nodes with values found - optimises the code by cutting down on unnecessary recursive calls
        if (x_parent != null && y_parent != null ) {
            return;
        }
        
        // when root value doesnt match x and y both, call recursive function for children of root
        dfs(root.left, x, y, level+1, root);
        dfs(root.right, x, y, level+1, root);
             
    }
    
    
}