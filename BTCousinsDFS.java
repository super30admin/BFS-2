// Time Complexity : O(n). n is the number of nodes in a tree
// Space Complexity : O(H). H is the height of the tree
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

    int xDepth,yDepth;
    TreeNode xParent,yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
       xDepth=0;yDepth=0;
        
        if(root==null) return false;
        
        cousins(root,0,null,x,y);
        return (xDepth==yDepth && xParent!=yParent); 
    }
    
    private void cousins(TreeNode node,int depth,TreeNode parent,int x,int y){
        
        if(node==null) return;
        
        if(node.val==x){
            xDepth=depth;
            xParent = parent;
        }
        
        if(node.val==y){
            yDepth=depth;
            yParent = parent;
        }
        
        cousins(node.left,depth+1,node,x,y);
        cousins(node.right,depth+1,node,x,y);
    }
}
