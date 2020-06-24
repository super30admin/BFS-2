// Time Complexity : O(n) n is number of nodes
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    TreeNode x_par = null;
    TreeNode y_par = null;
    int x_dep = 0;
    int y_dep = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        depth(null,root,0,x,y);
        return x_dep==y_dep && x_par!=y_par;
        
    }
    private void depth(TreeNode parent, TreeNode node, int depth,int x,int y)
    {
        if(node==null) return;

       if(node.val==x)
       { 
           x_par=parent;
           x_dep=depth;
       }

       if(node.val==y)
       {
           y_par=parent;
           y_dep=depth;
       }

       depth(node,node.left,depth+1,x,y);
       depth(node,node.right,depth+1,x,y);
    }
}