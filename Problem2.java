// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    boolean flagx = true;
    boolean flagy = true;
    TreeNode parA;
    TreeNode parB;
    int levx;
    int levy;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,null,0,x,y);
        return parA!=parB && levx == levy;
    }
    private void helper(TreeNode root, TreeNode parent,int level,int x,int y){
        if(root == null)
            return;
        if(root.val == x){
            parA = parent;
            levx = level;
            flagx = false;
        }
        if(root.val == y){
            parB = parent;
            levy = level;
            flagy = false;
        }
        helper(root.left,root,level+1,x,y);
        helper(root.right,root,level+1,x,y);

    }
}
