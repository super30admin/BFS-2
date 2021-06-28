// Time Complexity: O(n) where n is the number of nodes
// Space Complexity: O(Edge)

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
    int xDepth = -1;
    int yDepth = -1;
    TreeNode xParent;
    TreeNode yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }
    
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null) return;
        
        if(root.val == x){
            xDepth = depth;
            xParent = parent;
        }
        if(root.val == y){
            yDepth = depth;
            yParent = parent;
        }
        dfs(root.left, x ,y, depth + 1, root);
        dfs(root.right, x ,y, depth + 1, root);
    }
}