// Time Complexity : O(n) n no.of nodes
// Space Complexity : O(1) l no.of levels
// Did this code successfully run on Leetcode :  yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach/**
dfs approach and checked if the levels and parents are matching as per the condition and return true
if parents ar enot equal and levels are equal and false if not;


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
   
    TreeNode x_parent = null,y_parent = null;
    int x_level = 0,y_level=0;
    public boolean isCousins(TreeNode root, int x, int y) {
        
        helper(root,x,y,0,null);
        if(x_parent!=y_parent && x_level==y_level) return true;
        return false;
       
    }
    private void helper(TreeNode root, int x,int y,int level,TreeNode parent){
        if(root == null) return;
        
        //logic
       
        helper(root.left,x,y,level+1,root);
        if(root.val == x) {
            x_parent = parent;
            x_level = level;
            
        }
        
        if(root.val == y) {
            y_parent = parent;
            y_level = level;
            
        }
        helper(root.right,x,y,level+1,root);
        
    }
}