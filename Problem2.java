// O(n) time complexity
//o(1) space complexity
//dfs
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
    int xHeight;
    int yHeight;
    int xParent;
    int yParent;
    int x;
    int y;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;

        helper(root,0, -1);
        if(xHeight == yHeight && xParent != yParent){
            return true;

        }

        return false;
        
    }
    private void helper(TreeNode root, int height, int parent ){

        if(root == null) { 
            
        return; }

        if(root.val == x){
            xHeight = height;
            xParent = parent;
        }
        if(root.val == y) {
            yHeight = height;
            yParent = parent;
        }

        helper(root.left, height+1, root.val);
        helper(root.right, height+1, root.val);
    }
}
