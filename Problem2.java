/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Time Complexity - O(n)
// Space Complexity - O(1) - Without Recursive stack
//                  - O(maxDepth) - With Recursive Stack;
class Solution {
    TreeNode parentX=null, parentY=null;
    int depthX=-1, depthY=-1;
    public boolean isCousins(TreeNode root, int x, int y) {

        dfs(root,x,y,0,null);
        return depthX == depthY && parentX != parentY;
    }

    private void dfs(TreeNode root,int x, int y,int depth, TreeNode parent){

        if(root==null)
            return;

        if(root.val == x){
            depthX = depth;
            parentX = parent;
        }

        if(root.val == y){
            depthY = depth;
            parentY = parent;
        }

        dfs(root.left,x,y,depth+1,root);
        dfs(root.right,x,y,depth+1,root);
    }
}