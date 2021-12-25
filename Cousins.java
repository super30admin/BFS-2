/*
Time Complexity : O(n)
Space Complexity : O(n)
 Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no

 Approach using DFS
 
 we need to mainatain level and its parent same we are passing it to dfs function

 */
class Solution {
    TreeNode x_parent;
    TreeNode y_parent;
    int xLevel;
    int yLevel;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
    dfs(root, x, y, 0, null);
    return x_parent != y_parent && xLevel == yLevel;
    }
    
    private void dfs(TreeNode root, int x , int y, int level, TreeNode parent){
        
        if(root == null){
            return;
        }
        
        if(root.val == x){
            x_parent = parent;
            xLevel = level;
        }
        if(root.val == y){
            y_parent = parent;
            yLevel = level;
        }
        dfs(root.left, x, y, level+1, root);
        dfs(root.right, x, y,level+1, root);
        
        
    }
}
