package bfs2;

import java.util.HashMap;

// Idea : Keep on storing depth and parent in separate hashmaps.
//		  Compare them and if depths are equal and parents are not same then conclude that it is a cousin.

// Time Complexity: O(n) where n is the number of nodes in the tree.
// Space Complexity: O(n) where n is the number of nodes in the tree.

class CousinsInBinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public HashMap<Integer, Integer> depth;
	public HashMap<Integer, TreeNode> parent;

	public boolean isCousins(TreeNode root, int x, int y) {

		depth = new HashMap<>();
		parent = new HashMap<>();
		helper(root, null);
		if (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y))
			return true;
		return false;
	}

	public void helper(TreeNode node, TreeNode par) {

		if (node != null) {
			depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
			parent.put(node.val, par);
			helper(node.left, node);
			helper(node.right, node);
		}
	}

	/*
	 * public boolean isCousins(TreeNode root, int x, int y) { if (getHeight(root,
	 * x, 1) != getHeight(root, y, 1)) return false; else { // Now check if or not
	 * parents are same for both the node, if not , // return true if
	 * (sameParents(root, x, y) == false) { return true; } else { return false; } }
	 * }
	 * 
	 * public int getHeight(TreeNode root, int x, int height) { if (root == null)
	 * return 0; if (root.val == x) return height;
	 * 
	 * int level = getHeight(root.left, x, height + 1); if (level != 0) return
	 * level; return getHeight(root.right, x, height + 1); }
	 * 
	 * public boolean sameParents(TreeNode root, int x, int y) { if (root == null)
	 * return false;
	 * 
	 * return ((root.left.val == x && root.right.val == y) || (root.left.val == y &&
	 * root.right.val == x) || sameParents(root.left, x, y) ||
	 * sameParents(root.right, x, y));
	 * 
	 * 
	 * }
	 */

}