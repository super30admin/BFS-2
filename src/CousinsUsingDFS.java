public class CousinsUsingDFS {

	int x_depth;
	int y_depth;
	TreeNode x_parent;
	TreeNode y_parent;

	public boolean isCousins(TreeNode root, int x, int y) {
		dfs(root, 0, null, x, y);
		return x_parent != y_parent && x_depth == y_depth;

	}

	private void dfs(TreeNode root, int level, TreeNode parent, int x, int y) {
		// TODO Auto-generated method stub

		// base
		if (root == null)
			return;

		// logic
		if (root.val == x) {
			x_depth = level;
			x_parent = parent;
		}
		if (root.val == y) {
			y_depth = level;
			y_parent = parent;
		}
		dfs(root.left, level + 1, root, x, y);
		dfs(root.right, level + 1, root, x, y);

	}

}
