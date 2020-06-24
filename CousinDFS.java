
// Time Complexity : O(n)
//Space Complexity : O(H) the width of the tree 
//Did this code successfully run on Leetcode : Yes

class Solution {
    TreeNode xParent; TreeNode yParent;
    int xdepth; int ydepth;
    
    public boolean isCousins(TreeNode root, int x, int y) {
         if(root == null) return false;
        dfs(root, 0, null, x, y);
        return xParent != yParent && xdepth == ydepth;
    }
    
    private void dfs(TreeNode root,int depth, TreeNode parent, int x, int y){
        
                //base
        if(root == null) return;
        //logic
        
        if(root.val == x){
            xParent = parent; 
            xdepth = depth;
        }
        if(root.val == y){
            yParent = parent; 
            ydepth = depth;
        }
        
        dfs(root.left, depth + 1, root, x, y);
        dfs(root.right, depth + 1,  root, x, y);
    }
}