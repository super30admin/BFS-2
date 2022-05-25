// Time Complexity :O(n)
// Space Complexity : O(h) - height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    //track of two different depths
    int depthx;
    int depthy;
    
    //since we need to check that parents are different
    TreeNode parentx;
    TreeNode parenty;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, null);
        return depthx==depthy && parentx!=parenty;
    }
    
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root==null){
            return;
        }
        //if value same store current depth and corresponding parents
        if(root.val==x){
            depthx=depth;
            parentx=parent;
        }
        if(root.val==y){
            depthy=depth;
            parenty=parent;
        }
        //iterate on both sides
        dfs(root.left, x, y, depth+1, root);
        dfs(root.right, x, y, depth+1, root);
    }
}