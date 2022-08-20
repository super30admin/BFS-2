//TC = O(n)
//SC = O(h)

class Solution {
      TreeNode x_parent;
      TreeNode y_parent;
      int x_depth;
      int y_depth;
        
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, x, y, 0, root);
        return x_depth == y_depth && x_parent != y_parent;
    }
    
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        //base
        if(root == null) return;
        
        //logic
        if(root.val == x){
            x_parent = parent;
            x_depth = depth;
        }
        
        if(root.val == y){
            y_parent = parent;
            y_depth = depth;
        }
        
        dfs(root.left, x,y, depth+1, root);
        dfs(root.right, x,y, depth+1, root);
    }
}




//TC = O(n)
//SC = O(h)
//Please explain if(x_parent == null || y_parent == null) , why we are checking this condition
class Solution {
      TreeNode x_parent;
      TreeNode y_parent;
      int x_depth;
      int y_depth;
        
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, x, y, 0, root);
        return x_depth == y_depth && x_parent != y_parent;
    }
    
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        //base
        if(root == null) return;
        
        //logic
        if(root.val == x){
            x_parent = parent;
            x_depth = depth;
        }
        
        if(root.val == y){
            y_parent = parent;
            y_depth = depth;
        }
        
        if(x_parent == null || y_parent == null)
           dfs(root.left, x,y, depth+1, root);
        if(x_parent == null || y_parent == null)
           dfs(root.right, x,y, depth+1, root);
    }
}
