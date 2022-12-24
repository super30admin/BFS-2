// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    TreeNode xParent;
    TreeNode yParent;
    int xLevel;
    int yLevel;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        if(x == y){
            return false;
        }
        
        return dfs(root, x, y, 0, null);
    }
    
    private boolean dfs(TreeNode root, int x, int y, int level, TreeNode parent){
        //base
        if(root == null){
            return false;
        }
        
        //logic
        // found x
        if(root.val == x){
            xParent = parent;
            xLevel = level;
        }
        
        // found y
        if(root.val == y){
            yParent = parent;
            yLevel = level;
        }
        
        if(xLevel == yLevel && xParent != yParent){
            return true;
        }
        
        return dfs(root.left, x, y, level+1, root) || dfs(root.right, x, y, level+1, root);
    }
}