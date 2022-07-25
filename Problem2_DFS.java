//Time Complexity: O(n)
//Space Complexity: O(h); Recursion Stack Space
//Code run successfully on LeetCode.

public class Problem2_DFS {

    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null)
            return false;
        
        dfs(root, 0 ,null,x,y);
        
        return ((x_depth == y_depth) && (x_parent != y_parent));
    }
    
    private void dfs(TreeNode root, int lvl, TreeNode parent, int x, int y){
        
        if(root == null)
            return;
        
        if(root.val == x){
            x_depth = lvl;
            x_parent = parent;
        }
        
        else if(root.val == y){
            y_depth = lvl;
            y_parent = parent;
        }
        
        if(x_parent != null && y_parent!= null)
            return;
        
        dfs(root.left, lvl +1, root, x, y);
        
         if(x_parent != null && y_parent!= null)
            return;
        
        dfs(root.right, lvl +1, root, x, y);
    }
}
