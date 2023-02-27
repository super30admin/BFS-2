//time complexity : O(m*n)
//space complexity : O(m*n)

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
    int x_depth,y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root==null) return true;
        dfs(root, 0, x,y,null);
        return (x_parent!=y_parent)&&(x_depth==y_depth);
    }
    private void dfs(TreeNode root, int depth, int x,int y,TreeNode parent){
        if(root==null) return;
        if(root.val==x) {
            x_parent=parent;
            x_depth=depth;
        }
        if(root.val==y) {
            y_parent=parent;
            y_depth=depth;
        }
        dfs(root.left,depth+1,x,y,root);
        dfs(root.right,depth+1,x,y,root);
    }
}
