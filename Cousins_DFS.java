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
//tc = o(n)
//sc - o(h)
class Solution {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_depth;
    int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
       dfs(root,x,y,0,null);
        if((x_parent != y_parent) && (x_depth == y_depth)) return true;
    else return false;
        
        }
    private void dfs(TreeNode root, int x,int y,int depth,TreeNode parent)
    {
        //base case
        if(root == null) return;
            
        //logic
            if(root.val == x)
            {
             x_depth = depth;
             x_parent = parent;
            }
            if(root.val == y)
            {
                y_depth = depth;
                y_parent = parent;
            }
        dfs(root.left,x,y,depth+1,root);
        dfs(root.right,x,y,depth+1,root);
        
    }
}