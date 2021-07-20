//Time Complexity : O(|V|), V -> Number of nodes
// Space Complexity : O(|V|) worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class Cousins {
	int[] parentArr;
	int[] depthArr;

	public boolean isCousins(TreeNode root, int x, int y) {
		if (root == null) {
			return true;
		}

		parentArr = new int[2];
		depthArr = new int[2];

		helper(root, null, x, y, 0);

		if (parentArr[0] != parentArr[1] && depthArr[0] == depthArr[1]) {
			return true;
		}

		return false;
	}

	/* Perform DFS for the given target nodes, to find their depth and parents. */
	public void helper(TreeNode root, TreeNode parent, int x, int y, int depth) {
		if (root == null) {
			return;
		}

		if (root.val == x) {
			parentArr[0] = parent != null ? parent.val : -1;
			depthArr[0] = depth;
		} else if (root.val == y) {
			parentArr[1] = parent != null ? parent.val : -1;
			depthArr[1] = depth;
		}

		helper(root.left, root, x, y, depth + 1);
		helper(root.right, root, x, y, depth + 1);
	}

	public static void main(String[] args) {
		Cousins obj = new Cousins();

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(15);

		System.out.println("Are nodes 7 and 15 cousins? " + (obj.isCousins(root, 7, 15) ? "Yes" : "No"));
	}

}
