// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// Do a DFS traversal and assign the respective parent nodes and the depths for x and y
// check if the nodes x and y are at same depth and have different parents, if yes return true else return false
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
    TreeNode xParent;
    TreeNode yParent;
    boolean xFound;
    boolean yFound;
    int xDepth;
    int yDepth;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
            return false;
        
        dfs(root,x,y,0,null);
        
        return xFound && yFound && xParent != yParent && xDepth == yDepth;
    }
    
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if(root == null)
            return;
        
        if(root.val == x) {
            xParent = parent;
            xDepth = depth;
            xFound = true;
        }
        
        if(root.val == y) {
            yParent = parent;
            yDepth = depth;
            yFound = true;
        }
        
        if(xFound && yFound)
            return;
        
        dfs(root.left, x, y, depth + 1, root);
        dfs(root.right, x, y, depth + 1, root);
    }
}