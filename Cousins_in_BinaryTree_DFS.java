// Time Complexity : O(N)
// Space Complexity : O(H), H is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Cousins_in_BinaryTree_DFS {
	TreeNode x_parent;
	TreeNode y_parent;
	int x_depth;
	int y_depth;

	public boolean isCousins(TreeNode root, int x, int y) {
		dfs(root, null, 0, x, y);
		return x_depth == y_depth && x_parent != y_parent;
	}

	private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y) {
		// base
		if (root == null)
			return;

		// logic
		if (root.val == x) {
			x_parent = parent;
			x_depth = depth;
		}
		if (root.val == y) {
			y_parent = parent;
			y_depth = depth;
		}
		dfs(root.left, root, depth + 1, x, y);
		dfs(root.right, root, depth + 1, x, y);
	}
}