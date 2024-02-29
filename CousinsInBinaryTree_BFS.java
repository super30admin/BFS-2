package week5.day2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution7 {
	public boolean isCousins(TreeNode root, int x, int y) {
		List<Integer> result = new ArrayList<>();
		boolean x_found = false;
		boolean y_found = false;
		if (root == null)
			return true;
		Queue<TreeNode> q = new LinkedList();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode curr = q.poll();
				if (curr.val == x) {
					x_found = true;
				}
				if (curr.val == y) {
					y_found = true;
				}
				if(curr.left != null && curr.right != null) {
                    if(curr.left.val==x && curr.right.val==y) return false;
                    if(curr.left.val==y && curr.right.val==x) return false;
				}
				if (curr.left != null)
					q.add(curr.left);
				if (curr.right != null)
					q.add(curr.right);
			}
            if(x_found && y_found) return true;
            if(x_found || y_found) return false;
		}
		return false; 
	}
}

public class CousinsInBinaryTree_BFS {

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
				Solution7 solution = new Solution7();
				boolean result = solution.isCousins(root, 4, 6);
				System.out.println(result);

	}
}

/*
 * class TreeNode { int val; TreeNode left; TreeNode right;
 * 
 * TreeNode() { }
 * 
 * TreeNode(int val) { this.val = val; }
 * 
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */