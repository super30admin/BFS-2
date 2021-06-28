package BFS2;


/* Time complexity : o(n) 
space complexity: o(n) 
Did this code run successfully in leetcode : yes
problems faces : no
*/
 
class isCousinsDFS {
	  //Definition for a binary tree node.
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	  
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) return false;
        dfs(root, null, 0, x, y);
        return x_parent != y_parent && x_depth == y_depth;
    }

    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y) {
        //Base
        if (root == null) return;
        //Logic
        if (root.val == x) {
            x_depth = depth;
            x_parent = parent;
        }
        if (root.val == y) {
            y_depth = depth;
            y_parent = parent;
        }
        dfs(root.left, root, depth + 1, x, y);
        dfs(root.right, root, depth + 1, x, y);

    }
}