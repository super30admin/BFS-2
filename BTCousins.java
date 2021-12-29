//Time Complexity :O(n)
//Space Complexity :O(n)
// leetcode : success

class Solution {
    TreeNode xparent = null;
    TreeNode yparent = null;
    int xlevel = -1 ;
    int ylevel = -1 ;
public boolean isCousins(TreeNode root, int x, int y) {
    
    helper(root,x, y,null,0);
    if(xlevel == ylevel && xparent != yparent){
        return true;
    }    
    return false;   
}

private void helper (TreeNode root, int x, int y , TreeNode parent , int level){
    
    if(root == null){
        return;
    }
    
    if(x == root.val){
        xlevel = level;
        xparent = parent;
    }
    if(y == root.val){
        ylevel = level;
        yparent = parent;
    }
    parent = root;
    
    helper(root.right,x,y,parent,level+1);
    helper(root.left,x,y,parent,level+1);
}
}
