// Time Complexity : O(n) 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    
        private int depthX=-1;
        private int depthY=-1;
        
        private TreeNode parentX=null;
        private TreeNode parentY=null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root==null){
            return false;
        }
        recurr(root,x,y,0,null);
        
        return(depthX==depthY)&&(parentX!=parentY);
    }
    
    public void recurr(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root==null){
            return;
        }
        
        if(root.val==x){
            depthX=depth;
            parentX=root;
        }else if(root.val==y){
            depthY=depth;
            parentY=root;
        }
        
        recurr(root.left,x,y,depth+1,root);
        recurr(root.right,x,y,depth+1,root);
    }
}