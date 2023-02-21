import java.util.LinkedList;
import java.util.Queue;

//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None


/**
 * Apply level order traversal. Maintain two parent nodes to store
 * parents of x and y. parents are updated by checking if their children
 * are x or y. Once parents are updated, in the same level, check if 
 * both parents are same. if so return false. if not, then iterate the queue
 * to see if both x and y are present. If present return true, else false.
 *
 */
class Solution {
	public boolean isCousins(TreeNode root, int x, int y) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		TreeNode p1 = null;
		TreeNode p2 = null;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null && node.left.val == x || node.right != null && node.right.val == x)
					p1 = node;
				if (node.left != null && node.left.val == y || node.right != null && node.right.val == y)
					p2 = node;
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}

			if (p1 != null || p2 != null) {
				if (p1 == p2)
					return false;
				int count = 0;
				while (!queue.isEmpty()) {
					TreeNode temp = queue.poll();
					if (temp.val == x || temp.val == y)
						count++;
				}
				return count == 2;
			}
		}
		return false;
	}
}