package week5.day2;

import java.util.ArrayList;
import java.util.List;

class Solution4 {
	List<Integer> result;

	public List<Integer> rightSideView(TreeNode root) {
		result = new ArrayList<>();
		dfs(root, 0);
		return result;
	}

	private void dfs(TreeNode root, int level) {
		if (root == null)
			return;
		if (level == result.size()) {
			result.add(root.val);
		}
		dfs(root.right, level + 1);
		dfs(root.left, level + 1);
	}
}

public class RightSideViewTree_DFS {

	public static void main(String[] args) {
		// Create a sample binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		// Create an instance of Solution class
		Solution4 solution = new Solution4();
		List<Integer> result = solution.rightSideView(root);
		System.out.println(result);
	}

}
/*
 * class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */