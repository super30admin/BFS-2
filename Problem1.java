//Cousins in a binary tree
//time
//space
//time o(n)
//space o(h) height of the tree
class Solution {
    TreeNode parent_x, parent_y;
    int level_x, level_y;
    boolean flag = false;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, x, y, null, 0);
        
        if(flag)
            return false;
        
        if(level_x == level_y && parent_x != parent_y)
            return true;
        return false;
    }
    
    private void helper(TreeNode root, int x, int y, TreeNode parent, int level) {
        //base case
        if(root == null)
            return;
        //logic
        if(root.left !=null && root.right !=null && root.left.val == x && root.right.val == y) {
            flag = true;
            return;
        }
        if(root.left !=null && root.right !=null && root.left.val == y && root.right.val == x) {
            flag = true;
            return;
        }
        if(root.val == x){
            parent_x = parent;
            level_x = level;
        }
        if(root.val == y){
            parent_y = parent;
            level_y = level;
        }
        helper(root.left, x, y, root, level+1);
        helper(root.right, x, y, root, level+1);
    }
}