// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Preorder DFS.
When x and y are found, mark the depth and parents
if depth is same and parents are different return true, else false
*/
class CousinsInBinaryTree {
    int xDepth=-1;
    int yDepth=-1;
    TreeNode xParent=null;
    TreeNode yParent=null;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;

        getDepth(root,x,y,0,null);
        return (xDepth==yDepth) && (xParent!=yParent);
    }

    private void getDepth(TreeNode root, int x,int y, int level, TreeNode parent){
        if(root==null) return;

        if(root.val==x){
            xDepth=level;
            xParent=parent;
        } else if(root.val==y){
            yDepth=level;
            yParent=parent;
        }

        if(xParent==null || yParent==null){
            getDepth(root.left,x,y,level+1,root);
            getDepth(root.right,x,y,level+1,root);
        }
    }
}