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
    //Time complexity: O(n)
    //Space complexity: O(n)
    TreeNode x_parent,y_parent;
    int x_ht,y_ht;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,x,y,0,null);
        return x_parent!=y_parent && x_ht==y_ht;
    }
    private void dfs(TreeNode root,int x,int y,int level,TreeNode parent){
        if(root==null)
            return;
        if(root.val==x){
            x_parent=parent;
            x_ht=level;
        }
        if(root.val==y){
            y_parent=parent;
            y_ht=level;
        }
        dfs(root.left,x,y,level+1,root);
        dfs(root.right,x,y,level+1,root);
    }
}