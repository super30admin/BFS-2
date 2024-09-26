/**
 * TC : O(N) SC : (N)
 */
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
    int xParent, yParent, xDepth, yDepth;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root,null,0,x,y);
        // System.out.println("x  Parent"+xParent+"yParennt : "+yParent+"xDepth : "+xDepth+"yDepth : "+ yDepth);
        return xParent!= yParent && xDepth == yDepth;
    }
    
    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y){
        // Base
        if(root == null) return;
        
        //Logic
        if(root.val == x){
            if(parent != null){    
                xParent = parent.val;
                xDepth = depth;
            }
        }else if(root.val == y){
            if(parent != null){    
                yParent = parent.val;
                yDepth = depth;
            }
        }
        depth++;
        dfs(root.left,root,depth,x,y);
        dfs(root.right,root,depth,x,y);
    }
}