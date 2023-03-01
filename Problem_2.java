// Time Complexity : O(n) where n is the no of nodes in tree
// Space Complexity : O(h), height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use dfs to find the depth and parent of both nodes. Once we find the target node we update its depth and parent.
   After dfs we compare and depth values. If both depths are same but parents are different we return true else we return false.
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
class Solution {
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        dfs(root, x, y, 0,null);
        return x_depth == y_depth && x_parent != y_parent;
    }

    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if(root == null)
            return;
        
        if(root.val == x) {
            x_depth = depth;
            x_parent = parent;
        }
        if(root.val == y) {
            y_depth = depth;
            y_parent = parent;
        }
        if(x_parent == null || y_parent == null)
            dfs(root.left,x,y,depth + 1, root);
        if(x_parent == null || y_parent == null)
            dfs(root.right,x,y,depth + 1, root);
    }
}