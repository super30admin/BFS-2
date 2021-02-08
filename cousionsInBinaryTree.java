    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/cousins-in-binary-tree/
    Time Complexity for operators : o(n)
    Extra Space Complexity for operators : o(n) ... recursive stack case of recursion
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach 

        # Optimized approach: Recursion.
                              
              # - Approach
                    A. Declare 4 global variable depthX, depthY, parentX, parentY.
                    B. Do the traversal thru each node via recursion.
                    C. If the ree has values of x and y, then change the globale variables accordingly
                    D. At the end check those global variables and return the value accordingly.
       */

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
class cousionsInBinaryTree {
    int depthX = -1;
    int depthY = -1;
    TreeNode parentX = null;
    TreeNode parentY = null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        
        recursive(root,x,y,0,null);
        
        return (depthX == depthY && parentX!=parentY);
    }
    
    private void recursive(TreeNode root,int x, int y, int depth, TreeNode parent){
        if(root==null)
            return;
        
        if(root.val == x){
            depthX = depth;
            parentX = parent;
        }else if (root.val == y){
            depthY = depth;
            parentY = parent;
        }
        
        recursive(root.left,x,y,depth+1,root);
        recursive(root.right,x,y,depth+1,root);
    }
}