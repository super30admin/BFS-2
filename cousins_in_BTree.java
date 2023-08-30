//using DFS
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
    TreeNode x_parent;
    TreeNode y_parent;
    int depth_x;
    int depth_y;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
        {
            return false;
        }
        dfs(root,x,y,0,null);
        return depth_x==depth_y && x_parent!=y_parent;
    }
    public void dfs(TreeNode root,int x,int y, int depth,TreeNode parent )
    {
        if(root==null)
            return;
        if(root.val==x)
        {
            x_parent=parent;
            depth_x=depth;
        }
        if(root.val==y)
        {
            y_parent=parent;
            depth_y=depth;
        }

        dfs(root.left,x,y,depth+1,root);
        dfs(root.right,x,y,depth+1,root);
    }
}