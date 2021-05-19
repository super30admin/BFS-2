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
    //Time O(N)
    //Space O(H)
    int X_level = -2 , Y_level = -1;
    TreeNode X_parent , Y_parent;
    boolean result = false;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
        {
            return true;
        }
        helper(root , null, 0, x, y);
        return result;
    }
    public void helper(TreeNode root, TreeNode parent, int level, int x,int y)
    {
        //base
        if(root == null)
        {
            return;
        }
        //logic
        if(root.val == x)
        {
            X_level = level;
            X_parent = parent;
        }
        if(root.val == y)
        {
            Y_level = level;
            Y_parent = parent;
        }
        if(X_level == Y_level && X_parent != Y_parent)
        {
            result = true;
            return;
        }
        helper(root.left , root, level+1, x, y);
        helper(root.right , root, level+1, x, y);
    }
}