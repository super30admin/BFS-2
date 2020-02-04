// S30 Big N Problem #59 {Easy}
// 993. Cousins in Binary Tree
// Time Complexity :O(n) where n is the number of nodes
// Space Complexity :O(h) where h is the height of the binary tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None

// Your code here along with comments explaining your approach
// DFS solution
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
    TreeNode x_parent=null;
    TreeNode y_parent=null;
    int x_depth=0;
    int y_depth=0;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,x,y,0,null);
        return x_parent !=y_parent && x_depth==y_depth;
    }
    private void dfs(TreeNode root, int x, int y,int depth, TreeNode parent){
        //base
        if(root==null) return;
        //logic
        if(root.val==x){
            x_parent=parent;
            x_depth=depth;
        }
        if(root.val==y){
            y_parent=parent;
            y_depth=depth;
        }
        dfs(root.left,x,y,depth+1,root);
        dfs(root.right,x,y,depth+1,root);
    }
    
    
}