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
    
   /*
    * Procedure: Use DFS to find x & y individually
    *
    * After the end of DFS check: 
    *    1. if x & y are found at same level.
    *    2. x & y doesn't belong to same parent.
    *
    * Time complexity: Visit every node once: O(no.of nodes)
    * Space complexity: Stack space for recursion, max stack space is when recursion is at leaf: 
    * 
    * O(no.of recursive calls made till leaf) == O(height of a tree) = O(logn) <- for a balanced tree.
    *. 
    */
    
    // Variables to track depth of x & y nodes
    private int xDepth = -1;
    private int yDepth = -1;
    
    // Variable to store xparent & y parent
    private TreeNode xParent = null;
    private TreeNode yParent = null;
    
    //storing globally so it need not be passed in every recursive call
    private int xVal;
    private int yVal;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        xVal = x;
        yVal = y;
        
        dfsHelper(root, null, 0);
        
        System.out.println("xDepth:" + xDepth + " yDepth:" + yDepth );
            
        System.out.println("xParent:" + xParent + " yParent:" + yParent);     
        
        if(xDepth == yDepth && xParent != yParent) return true;
        
        return false;
        
    }
    
    private void dfsHelper(TreeNode node, TreeNode parent, int depth) {
        // base case
        if(node == null) return;
        
        if(node.val == xVal) {
            xDepth = depth;
            xParent = parent;
        } 
        
        if(node.val == yVal) {
            yDepth = depth;
            yParent = parent;
        } 
        
        dfsHelper(node.left, node, depth+1);
        dfsHelper(node.right, node, depth+1);
    
    }
}
