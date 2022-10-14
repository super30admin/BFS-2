class Solution {
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        dfs(root, 0, null, x, y);
        if(x_depth == y_depth && x_parent != y_parent)
            return true;
        else
            return false;
    }
    
    void dfs(TreeNode root, int level, TreeNode parent, int x, int y){
        if(root == null)
            return;
        
        if(root.val == x){
            x_depth = level;
            x_parent = parent;
        }
        if(root.val == y){
            y_depth = level;
            y_parent = parent;
        }
        dfs(root.left, level+1, root, x, y);
        dfs(root.right, level+1, root, x, y);
    }
}

//Time Complexity :O(n)
//Space complexity :O(h) h = height of tree