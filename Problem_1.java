// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    TreeNode x_parent, y_parent;
    int x_depth, y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,null,0,x,y);
        return x_parent != y_parent && x_depth==y_depth;
        
        
    }
    
    public void dfs(TreeNode root, TreeNode parent, int depth, int x, int y){
        // base
        if(root == null) return;
        
        if(root.val==x){ // found x
            x_parent=parent;
            x_depth=depth;
        }
        
         if(root.val==y){ // found y
            y_parent=parent;
            y_depth=depth;
        }
        
        dfs(root.left,root,depth+1,x,y);
        dfs(root.right,root,depth+1,x,y);
        
    }
}