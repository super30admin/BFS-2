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

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class Cousins {
        int x_depth; int y_depth;
        TreeNode x_parent; TreeNode y_parent;
        public boolean isCousins(TreeNode root, int x, int y){
            dfs(root, null, 0, x, y);
            return x_parent != y_parent && x_depth == y_depth;
        }
        
        private void dfs(TreeNode root, TreeNode parent, int depth , int x , int y){
            
        if (root == null) return;
            //logic
        if (root.val == x){
            x_depth = depth;
            x_parent = parent;
            }
        if (root.val == y){
            y_depth = depth;
            y_parent = parent;
            }
            dfs(root.left, root, depth + 1, x ,y);
            dfs(root.right, root, depth + 1, x ,y);
        }
    }