// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    
    TreeNode xParent, yParent;
    boolean xFound, yFound;
    int xLevel, yLevel;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || x == root.val || y == root.val)
            return false;
        
        //root, level, parent, x, y
        dfs(root, 0, null, x, y);
        return xLevel == yLevel && xParent != yParent;
    }
    
    private void dfs(TreeNode root, int level, TreeNode parent, int x, int y){
        
        //base
        if(root == null) return;
        if(xFound && yFound) return;
        
        //logic
        if(root.val == x){
            xLevel = level;
            xFound = true;
            xParent = parent;
        }
        
        if(root.val == y){
            yLevel = level;
            yFound = true;
            yParent = parent;
        }
        
        dfs(root.left, level + 1, root, x, y);
        dfs(root.right, level + 1, root, x, y);
    }
}







