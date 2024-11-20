package CousinsInBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

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

class CousinsInBinaryTree {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isCousins(TreeNode root, int x, int y) {

		if(root == null)
			return false;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			int count = queue.size();
			boolean xFound = false, yFound = false;

			for(int i=0; i<count; i++) {
				TreeNode node = queue.poll();
				if(node.left != null && node.right != null) {
					if(node.left.val == x && node.right.val == y) return false;
					if(node.right.val == x && node.left.val == y) return false;
				}

				if(node.val == x) xFound=true;
				else if(node.val == y) yFound=true;

				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);

			}
			if(xFound && yFound) return true;
		}
		return false;
	}
}