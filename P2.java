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

//time- o(n)
//space- o(h)-height of tree
//passed in leetcode-

//dfs- 
class Solution {
    int x_parent;
    int x_depth;
    int y_parent;
    int y_depth;
    int xval;
    int yval;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root==null) return false;
        xval= x;
        yval= y;
        
        dfs(root, 0, -1);
        
        if(x_parent!=y_parent && x_depth==y_depth) return true; //they have the same depth, and have different parents.
        else return false;
    }
    
    public void dfs(TreeNode node, int depth, int parent) //parameters- node, its level and parent node value
    {
        if(node == null) return;
        
        if(node.val == xval) //if we found x
        {
            x_parent = parent;
            x_depth = depth;
        }
        
         
        if(node.val == yval) //if we found y
        {
            y_parent = parent;
            y_depth = depth;
        }
        
        dfs(node.left, depth+1, node.val);
        dfs(node.right, depth+1, node.val);
    }
}