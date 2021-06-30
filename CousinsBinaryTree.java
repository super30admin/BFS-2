// Time Complexity : O(n)
// Space Complexity : O(h), h - height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

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
class CousinsBinaryTree {
    int xDepth;
    int yDepth;
    TreeNode xParent;
    TreeNode yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return xDepth == yDepth && xParent != yParent;
    }
    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y){
        if(root == null){
            return;
        }
        
        if(root.val == x){
            xDepth = depth;
            xParent = parent;
        }
        
        if(root.val == y){
            yDepth = depth;
            yParent = parent;
        }
        
        dfs(root.left, root, depth+1, x, y);
        dfs(root.right, root, depth+1, x, y);
    }
}