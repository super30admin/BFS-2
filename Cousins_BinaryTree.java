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
 //TimeComplexity : O(n)
 //SpaceComplexity: O(n)
 class Solution {
    
    int x_level;
    int y_level;
    TreeNode x_parent=null;
    TreeNode y_parent=null;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }
        returnisCousins(root, null, 0, x, y);
        if(x_parent != y_parent && x_level==y_level) {
            return true;
        }
        return false;
    }
    void returnisCousins(TreeNode root, TreeNode parent, int level, int x, int y) {
        if(root == null) {
            return;
        }
        if(x == root.val) {
          x_parent = parent;
          x_level = level;
        }
        if(y == root.val) {
            y_parent = parent;
            y_level = level;
            
        }
    
            returnisCousins(root.left, root, level+1, x, y);
            returnisCousins(root.right, root, level+1, x, y);
        



    }
}