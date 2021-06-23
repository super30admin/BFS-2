//TC O(N)
//SC O(H) - auxillary stack space
class Solution {
    int xLevel;
    int yLevel;
    TreeNode xParent;
    TreeNode yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,null, 0, x, y);
        
        return xLevel == yLevel && xParent != yParent;
    }
    
    private void dfs(TreeNode root,TreeNode parent, int level, int x, int y){
        //base case
        if(root == null)
            return;
        
        //logic
        if(root.val == x){
            xLevel = level;
            xParent = parent;
        }
        
        if(root.val == y){
            yLevel = level;
            yParent = parent;
        }        
        dfs(root.left, root, 1+level, x, y);
        dfs(root.right, root, 1+level, x, y);
        
        
        
    }
}