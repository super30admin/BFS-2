/*In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
* TC O(N) SC O(H)
* Code was submitted on leetcode
*/
class Solution {
    int x_lvl, y_lvl;
    TreeNode x_parent, y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
         if (root == null)
            return false;
      dfs(root, null, 0, x, y);
      return (x_lvl == y_lvl && x_parent != y_parent);
    }
    
    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y) {
        if (root == null || (x_lvl == y_lvl && x_parent != y_parent))
            return;
        if (root.val == x) {
            x_lvl = level;
            x_parent = parent;
        }
        if (root.val == y) {
            y_lvl = level;
            y_parent = parent;  
        }
            
        dfs(root.left, root, level+1, x, y);
        dfs(root.right, root, level+1, x, y);
    }
}
