package week5.day2;

class Solution6 {
	boolean flag = false;
	int x_level = 0;
	int y_level = 0;
	TreeNode x_parent;
	TreeNode y_parent;

	public boolean isCousins(TreeNode root, int x, int y) {
		dfs(root, x, y, 0, null);
		return flag;
	}

	private void dfs(TreeNode root, int x, int y, int level, TreeNode parent) {
		if (root == null)
			return;
		if (root.val == x) {
			x_level = level;
			x_parent = parent;
		}
		if (root.val == y) {
			y_level = level;
			y_parent = parent;
		}
		if (x_level == y_level && x_parent != y_parent)
			flag = true;
		if (x_parent == null || y_parent == null) // adding this to avoid further calls once x_parent and y_parent is found
			dfs(root.left, x, y, level + 1, root);
		if (x_parent == null || y_parent == null) // add it as 2 seperate conditions, not as single if for above two
			dfs(root.right, x, y, level + 1, root);
	}
}

public class CousinsInBinaryTree_DFS {

	public static void main(String[] args) {
		// Create a sample binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		// Create an instance of Solution class
		Solution6 solution = new Solution6();
		boolean result = solution.isCousins(root, 4, 5);
		System.out.println(result);
	}

}
