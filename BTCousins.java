// Time Complexity : O(n) for traversing all the elements to find x and y
// Space Complexity : O(n) for recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Use DFS to traverse to every element of the tree.
// keep a track of global costants for both parents and both heights while traversing.
// if found add them to our global constants and check for the condition to return.

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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        recurr(root,null,0,x,y);
        return (leftparent!=rightparent && leftlevel==rightlevel);
    }
    TreeNode leftparent=null, rightparent=null;
    int leftlevel=0, rightlevel=0;

    private void recurr(TreeNode root,TreeNode parent, int height, int x, int y){
        if(root == null){
            return;

        }
        if(root.val == x){
            leftparent = parent;
            leftlevel = height;

        }
        if(root.val == y){
            rightparent = parent;
            rightlevel = height;
        }
        recurr(root.left,root,height+1,x,y);
        recurr(root.right,root,height+1,x,y);
    }
}