/**
## Problem 2
Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)
 
Time Complexity :   O (N) 
Space Complexity :  O (h)
Did this code successfully run on Leetcode :    Yes (993. Cousins in Binary Tree)
Any problem you faced while coding this :       No
 */

// Input: root = [1,2,3,4], x = 4, y = 3
// Output: false

class IsCousins {
    TreeNode xParent, yParent;
    int xDepth, yDepth;
    public boolean isCousins(TreeNode root, int x, int y) {
        // null case
        if(root == null)
            return false;
        
        // call DFS with x, y, depth and parent
        dfs(root,x,y, 0, null);

        // condition for cousins
        return xParent != yParent && xDepth == yDepth;
        
    }
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent){
        // base case
        if(root == null)
            return;
        
        //logic
        if(root.val ==x){
            xParent = parent;
            xDepth = depth;
        }
        if(root.val ==y){
            yParent = parent;
            yDepth = depth;
        }
        
        dfs(root.left , x, y, depth+1, root);
        dfs(root.right , x, y, depth+1, root);
    }
}