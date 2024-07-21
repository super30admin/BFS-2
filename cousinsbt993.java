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
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    int px=-1;
    int py=-1;
    int dx=-1;
    int dy=-1;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        getParents(root,x,y);
        getDepth(root, x,y,0);
        return (px!=py) && (dx == dy);
    }

    public void getParents(TreeNode root, int x, int y){
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        if(root.left != null ){
            if( root.left.val == x){
                px = root.val;
            }
            if( root.left.val == y){
                py = root.val;
            }
        }
        if(root.right != null ){
            if( root.right.val == x){
                px = root.val;
            }
            if( root.right.val == y){
                py = root.val;
            }
        }
        getParents(root.left, x, y);
        getParents(root.right,x,y);
    }

    public  void getDepth(TreeNode root, int x, int y, int d){
        if(root == null) return;
        if(root.val == x){
            dx = d+1;
        }
        if(root.val == y){
            dy = d+1;
        }
        if(root.left == null && root.right == null) return;
        getDepth(root.left, x,y,d+1);
        getDepth(root.right,x,y,d+1);
    }
}
