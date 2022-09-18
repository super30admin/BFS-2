// TC : O(n)
// SC : O(h)
// Ran on LC : Yes
// Problems : None.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	TreeNode x_parent;
	TreeNode y_parent;
	int x_depth;
	int y_depth;
	public boolean isCousins(TreeNode root, int x, int y) {
		 if(root == null) return false;
		 
		 // dfs(root, x, y, 0, null);
		 
		 // return x_parent != y_parent && x_depth == y_depth;
		 
		 Queue<TreeNode> q = new LinkedList<>();
		 
		 q.add(root);
		 
		 while(!q.isEmpty()) {
			  int size = q.size();
			  boolean x_found = false;
			  boolean y_found = false;
			  
			  for(int i = 0; i < size; i++) {
					TreeNode curr = q.poll();
					
					if(curr.val == x) x_found = true;
					if(curr.val == y) y_found = true;
					
					if(curr.left != null && curr.right != null) {
						 if(curr.left.val == x && curr.right.val == y) return false;
						 if(curr.left.val == y && curr.right.val == x) return false;
					}
					
					if(curr.left != null) q.add(curr.left);
					if(curr.right != null) q.add(curr.right);
			  }
			  if (x_found && y_found) return true;
			  if (x_found || y_found) return false;
		 }
		 return false;
	}
	
	private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
		 //base
		 if(root == null) return;
		 
		 //logic
		 if(root.val == x) {
			  x_depth = depth;
			  x_parent = parent;
		 }
		 
		 if(root.val == y) {
			  y_depth = depth;
			  y_parent = parent;
		 }
		 
		 if(x_parent == null || y_parent == null)
			  dfs(root.left, x, y, depth+1, root);
		 
		 if(x_parent == null || y_parent == null)
			  dfs(root.right, x, y, depth+1, root);
	}
}