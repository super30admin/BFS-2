package BFS-2;

public class problem2 {
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

TreeNode x_parent, y_parent;
    int x_lvl, y_lvl;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || x == y) return false;
        helper(root,x,y, null,0);
        return x_parent != y_parent && x_lvl == y_lvl;
    }
    
    public void helper(TreeNode root, int x, int y, TreeNode parent, int lvl){
        //base
        if(root == null) return;
        
        //logic
        if(x == root.val){
            x_parent = parent;
            x_lvl = lvl;
        }
        if(y == root.val){
            y_parent = parent;
            y_lvl = lvl;
        }
        
        if(x_parent == null || y_parent == null){
            helper(root.left, x, y, root, lvl+1);
        }
        if(x_parent == null || y_parent == null){
            helper(root.right, x, y, root, lvl+1);
        }
       
    }
}
