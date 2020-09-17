// Time Complexity : O(V)
// Space Complexity : O(n) for recursive stack else O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
      int depthX=-1;
        int depthY=-1;
        
        TreeNode parentX=null;
        TreeNode parentY=null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        
        recur(root,x,y,0,null);
        return (depthX==depthY) && (parentX!=parentY);
    }
    
    private void recur(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root==null){
            return;
        }
        if(root.val==x){
          depthX=depth;
          parentX=parent;
        }
        else if(root.val==y){
            depthY=depth;
          parentY=parent;
        }
        recur(root.left,x,y,depth+1,root);
        recur(root.right,x,y,depth+1,root);
    }
}