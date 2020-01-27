package ZigZagLevelOrderTraversal;
import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Time Complexity - O(n)
//Space Complexity - O(n)

class ZigZagLevelOrderTraversal {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean leftFromRight = true;
		while (!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			int count = queue.size();
			for (int i = 0; i < count; i++) {
				TreeNode node = queue.poll();
				temp.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			if (!leftFromRight)
				Collections.reverse(temp);
			result.add(temp);
			leftFromRight = !leftFromRight;
		}
		return result;
	}
}