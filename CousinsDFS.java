//Time Complexity:O(n)
//Space Complexity:O(h)

//DEPTH FIRST SEARCH
class Solution {
    TreeNode xparent;
    TreeNode yparent;
    int xlevel;
    int ylevel;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        helper(root,null,0,x,y);
        if(xparent!=yparent && xlevel==ylevel){
            return true;
        }
        return false;
    }
    
    private void helper(TreeNode root, TreeNode parent, int level, int x, int y){
        if(root==null){
            return;
        }
        if(root.val==x){
            xparent=parent;
            xlevel=level;
        }
        if(root.val==y){
            yparent=parent;
            ylevel=level;
        }
        helper(root.left,root,level+1,x,y);
        helper(root.right,root,level+1,x,y);
    }
}