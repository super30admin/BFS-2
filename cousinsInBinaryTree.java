
//Time Complexity: O(N)
//Space Somplexity: O(H)
//Using DFS
class Solution {
    TreeNode x_parent; TreeNode y_parent;
    int x_height; int y_height;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, null, 0, x, y);
        return x_parent != y_parent && x_height == y_height;
    }
    private void dfs(TreeNode root,TreeNode parent, int height, int x, int y ){
        //base
        if(root == null) return;
        
        //logic
        if(x == root.val ){
            x_parent = parent;
            x_height = height;
        }
        if(y == root.val ){
            y_parent = parent;
            y_height = height;
        }
        dfs(root.left, root, height+1, x,y);
        dfs(root.right, root, height+1, x,y);
            
        
    }
}