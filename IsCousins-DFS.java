/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int depth_x = -1;
    int depth_y = -1;
    TreeNode parent_x = null;
    TreeNode parent_y = null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        recurr(root,x,y,0,null);
        
        return ((depth_x == depth_y) && (parent_x != parent_y));
        
    }
    
    private void recurr(TreeNode root, int x, int y, int depth, TreeNode parent){
        
        if (root == null)return;
        
        if (root.val == x && parent_x == null){
            depth_x = depth;
            parent_x = parent;
        }
        
        if (root.val == y && parent_y == null){
            depth_y = depth;
            parent_y = parent;
        }
        
        recurr(root.left, x,y,depth+1,root);
        recurr(root.right, x,y,depth+1,root);
        
        
    }
}