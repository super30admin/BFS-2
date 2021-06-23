// Time Complexity : O(N) 
// Space Complexity : O(N)  
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Run BFS on tree.
 * 2. both the elements should be at same level else return false.
 * 3. both elements should not have same parent check when visit the parent.
 */

import java.util.LinkedList;
import java.util.Queue;

public class CousinsBinaryTreeBFS {
	public boolean isCousins(TreeNode root, int x, int y) {

		if (root == null)
			return false;
		if (root.val == x || root.val == y)
			return false;

		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);
		while (!queue.isEmpty()) {
			int count = queue.size();
			boolean xfound = false;
			boolean yfound = false;
			for (int i = 0; i < count; i++) {
				TreeNode node = queue.poll();

				if (node.val == x)
					xfound = true;
				if (node.val == y)
					yfound = true;

				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);

				// parent check
				if (node.left != null && node.right != null && ((node.left.val == x && node.right.val == y)
						|| ((node.left.val == y && node.right.val == x)))) {
					return false;
				}
			}

			if (xfound && yfound)
				return true;
			if (xfound || yfound)
				return false;

		}

		return false;
	}
}

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
