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
/* Time Complexity : O(n) 
 *  n - length of the tree */
/* Space Complexity : O(h)
 *  h - height of the tree */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//DSF solution
class Solution {
    int depth_x;
    int depth_y;
    TreeNode parent_x;
    TreeNode parent_y;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, null, 0);
        return (depth_x == depth_y) && (parent_x != parent_y);
    }

    private void dfs(TreeNode root, int x, int y, TreeNode parent, int depth){
        //base condition
        if(root == null) return;
        //logic
        if(root.val == x){
            depth_x = depth;
            parent_x = parent;
        }
        if(root.val == y){
            depth_y = depth;
            parent_y = parent;
        }

        if(parent_x == null || parent_y ==null)
            dfs(root.left, x, y, root, depth+1);
        if(parent_x == null || parent_y ==null)
            dfs(root.right, x, y, root, depth+1);
    }
}