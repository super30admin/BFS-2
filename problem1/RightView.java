//Time Complexity : O(|V|), V -> Number of nodes
// Space Complexity : O(|V|) worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightView {
	/*
	 * Perform level order traversal of tree. Include only the last element of each
	 * level
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> rightView = new ArrayList<Integer>();

		if (root == null) {
			return rightView;
		}

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (queue.size() > 0) {
			int n = queue.size();
			for (int i = 0; i < n; i++) {
				TreeNode curNode = queue.remove();
				if (i == 0) {
					rightView.add(curNode.val);
				}

				if (curNode.right != null) {
					queue.add(curNode.right);
				}

				if (curNode.left != null) {
					queue.add(curNode.left);
				}
			}
		}
		return rightView;
	}

	public static void main(String[] args) {
		RightView obj = new RightView();

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		List<Integer> rightView = obj.rightSideView(root);

		System.out.println("Right view of tree: ");

		for (Integer node : rightView) {
			System.out.print(node + " ");
		}
	}

}
