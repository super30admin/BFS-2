// Time Complexity : 0(N)
// Space Complexity : 0(h) for recursive stack (h = height of binary tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Cousins {
    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDepth = -1;
    int yDepth = -2; //initailizing -2 so that it is not equal to xDepth

    public boolean isCousins(TreeNode root, int x, int y) {
        findMaxDepthAndParent(root, null, 0, x, y);
        //For cousins, depth should be equal and parents should be different
        return (xDepth == yDepth && xParent != yParent);
    }

    public void findMaxDepthAndParent(TreeNode root, TreeNode parent, int depth, int x, int y){
        if(root == null)
            return;

        if(root.val == x){
            xParent = parent;
            xDepth = depth;
        }else if(root.val == y){
            yParent = parent;
            yDepth = depth;
        }else{
            //we don't need to do dfs deeper when we have already found x, y
            findMaxDepthAndParent(root.left, root, depth+1, x, y);
            findMaxDepthAndParent(root.right, root, depth+1, x, y);
        }
    }
}