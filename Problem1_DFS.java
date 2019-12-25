/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(N)

The idea is to use DFS to traverse the tree recursivey such that at each depth we are increasing depth and changing parent such that when the node in question is encountered we store it in the global variable for final comparison.
**/

class Solution {
    int x_depth  = 0;
    int y_depth  = 0;
    TreeNode x_parent = null;
    TreeNode y_parent = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        
        TreeNode parent = null;
        checkParent(root,x,y,parent,0);
        
        return (x_depth == y_depth) && (x_parent != y_parent);
        
    }
    
    private void checkParent(TreeNode root, int x, int y, TreeNode parent,int depth){
        //Base Class
        if(root == null)
            return;
        
        if(root.val == x){
            x_depth  =  depth;
            x_parent =  parent;
        }
        
        if(root.val == y){
            y_depth  =  depth;
            y_parent =  parent; 
        }
        checkParent(root.left,x,y,root,depth+1);
        checkParent(root.right,x,y,root,depth+1);
        
    }
}
