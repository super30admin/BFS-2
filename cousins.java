// Time complexity-O(n) space-O(h)

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
    int x_depth = 0;
    int y_depth = 0;
    TreeNode x_parent;
    TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,null,0,x,y);

        return x_parent!=y_parent && x_depth==y_depth;
    }

    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y){

        if(root==null) return;

        if(root.val==x){
            x_parent=parent;
            x_depth=level;
        }

        if(root.val==y){
            y_parent=parent;
            y_depth=level;
        }

        dfs(root.left,root,level+1,x,y);
        dfs(root.right,root,level+1,x,y);
    }
}