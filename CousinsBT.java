// TC : SC : O(n)
//  DFS
class Solution {
    int x_level, y_level;
    TreeNode x_parent, y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, x, y, 0, null);
        return x_level == y_level && x_parent != y_parent;
    }
    private void helper(TreeNode root, int x, int y, int level, TreeNode parent){
        
        // base case
        if(root == null || (x_parent != null && y_parent != null)) return;

        if(root.val == x){
            x_level = level;
            x_parent = parent;
        }
        if(root.val == y){
            y_level = level;
            y_parent = parent;
        }

        // if(x_parent == null || y_parent == null) //to sto with recursion on right side or can be included in base case
            helper(root.left, x, y, level+1, root);

        // if(x_parent == null || y_parent == null)
            helper(root.right, x, y, level+1, root);

    }
}