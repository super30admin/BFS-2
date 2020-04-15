// Time Complexity : O(n)
// Space Complexity : O(h) maximum depth
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
        int depth_x = -1;
        int depth_y = -1;
    
        TreeNode parent_x = null;
        TreeNode parent_y = null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,x,y,0,null);
        
        return (depth_x == depth_y) && (parent_x != parent_y);        
    }
    
    private void helper(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root==null)return;
        
        if(root.val==x && parent_x ==null){
            depth_x = depth;
            parent_x = parent;
        }
        
        if(root.val==y && parent_y ==null){
            depth_y = depth;
            parent_y = parent;
        }
        
        helper(root.left,x,y,depth+1,root);
        helper(root.right,x,y,depth+1,root);
    }
}