// Time complexity is O(N) as we iterate through all the nodes
// Space Complexity isO(n) as we are using a queue
// this solution is submitted on leetcode
import java.util.LinkedList;
import java.util.Queue;

public class BigN59CousinsBinaryTreeUsingBFS {
	public boolean isCousins(TreeNode root, int x, int y) {
		// edge case
		if (root == null)
			return false;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			boolean x_found = false;
			boolean y_found = false;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.val == x)
					x_found = true;
				if (node.val == y)
					y_found = true;
				if (node.left != null && node.right != null) {
					if (node.left.val == x && node.right.val == y)
						return false;
					if (node.right.val == x && node.left.val == y)
						return false;
				}
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			if (x_found && y_found)
				return true;
		}
		return false;
	}
}