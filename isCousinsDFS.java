// Time Complexity :O(n) n is the nodes of the tree;
// Space Complexity :O(h) h is the height of the recursive stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    TreeNode parentX; TreeNode parentY;
    int xDepth; int yDepth;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        dfs(root,null,0,x,y);
        return parentX!=parentY && xDepth==yDepth;
    }
    
    private void dfs(TreeNode root,TreeNode parent, int depth, int x,int y){
        if(root == null) return;
        
        if(root.val == x){
            parentX = parent;
            xDepth = depth;
        }
        if(root.val == y){
            parentY = parent;
            yDepth = depth;
        }
        
        dfs(root.left,root,depth +1,x,y);
        dfs(root.right,root,depth +1,x,y);
    }
}