//Time complexity: O(N)
//Space complexity: O(N)
class Solution {
    int x_depth = -1;
    int y_depth = -1;
    TreeNode x_parent = null;
    TreeNode y_parent = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        helperMethod(root, x, y, 0, null);
        return x_depth == y_depth && x_parent != y_parent;
    }
    
    public void helperMethod(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if(root == null) {
            return;
        }
        if(root.val == x) {
            x_parent = parent;
            x_depth = depth;
        }
        if(root.val == y) {
            y_parent = parent;
            y_depth = depth;
        }
        helperMethod(root.left, x, y, depth + 1, root);
        helperMethod(root.right, x, y, depth + 1, root);
    }
}