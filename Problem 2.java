// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    // We will find x and populate its xValues

    // we will find y and poplate its values once we find it, we would compare

    TreeNode xParent;
    int xLevel;
    TreeNode yParent;
    int yLevel;
    public boolean isCousins(TreeNode root, int x, int y) {
        return dfsHelper(root,x,y,null,0);
    }

    private boolean dfsHelper(TreeNode root, int x, int y,TreeNode parent,int level){

        // base case
        if(root == null){
            return false;
        }

        //logic
        if(root.val == x){
            xParent = parent;
            xLevel = level;
            //check if y was found
            if(yParent!=null){
                // it is found
                return (xParent!=yParent) && (xLevel==yLevel);
            }

        }else if(root.val == y){
            yParent = parent;
            yLevel = level;
            //check if x was found
            if(xParent!=null){
                // it is found
                return (xParent!=yParent) && (xLevel==yLevel);
            }
        }

        //recurse
        return dfsHelper(root.left,x,y,root,level+1) || dfsHelper(root.right,x,y,root,level+1);
        

    }
}