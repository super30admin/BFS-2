// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public class cousinsBT {
    int x_depth; int y_depth;
    TreeNode x_par; TreeNode y_par;
    public boolean isCousins(TreeNode root, int x, int y) {
        
        dfs(root, 0,null, x,y);
        
        return x_depth==y_depth && x_par!=y_par;
        
    }
    
    
    private void dfs(TreeNode root, int depth, TreeNode parent, int x, int y){
        if(root ==null)
            return;
        
        if(root.val==x){
            x_depth=depth;
            x_par=parent;
        }
        if(root.val==y){
            y_depth=depth;
            y_par=parent;
        }
        
        
        dfs(root.left,depth+1,root, x,y);
        dfs(root.right,depth+1,root, x,y);
    }
}
