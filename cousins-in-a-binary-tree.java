// Time - O(N)
// Space - O(H)

class Solution {
    int heightX;
    int heightY;
    TreeNode parentX;
    TreeNode parentY;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }
        parentX = null;
        parentY = null;
        
        dfs(root, x, y, 0, null);
                
        return heightX == heightY && parentX != parentY;
    }
    
    private void dfs(TreeNode root, int x, int y, int level, TreeNode parent) {
        if(root == null) {
            return;
        }
        
        if(root.val == x) {
            heightX = level;
            parentX = parent;
        }
        if(root.val == y) {
            heightY = level;
            parentY = parent;
        }
        dfs(root.left, x, y, level + 1, root);
        dfs(root.right, x, y, level + 1, root);
    }
}
