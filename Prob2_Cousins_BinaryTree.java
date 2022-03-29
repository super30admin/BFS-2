// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

//We have to check that x and y are at same height/ depth and with different parent nodes.


class Solution {
    TreeNode x_p, y_p;
    int xHeight, yHeight;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, x, y, 0, null);
        
        return x_p != y_p && xHeight == yHeight;
    }
    public void helper(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null)    return;
        
        if(root.val == x){
            x_p = parent;
            xHeight = depth;
        }
        if(root.val == y){
            y_p = parent;
            yHeight = depth;
        }
        if(x_p != null && y_p != null)  return; //If we got parent of both the nodes, stop the process.
        
        helper(root.left, x, y, depth + 1, root);
        helper(root.right, x, y, depth + 1, root);
        
    }
}