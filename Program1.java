package LeetCode;

public class Program1 {/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 * 
	 * 
	 * T.C =  O(n)
	 * S.C =  O(n)
	 */
	class Solution {
	    public boolean isCousins(TreeNode root, int x, int y) {
	        // BFS find the cousins
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        
	        while (!queue.isEmpty()) {
	            TreeNode xParent = null, yParent = null;
	            for (int i = queue.size(); i > 0; -- i) {
	                root = queue.poll();
	                if (root.left != null) {
	                    if (root.left.val == x) {
	                        xParent = root;
	                    }
	                    if (root.left.val == y) {
	                        yParent = root;
	                    }
	                    queue.offer(root.left);
	                }
	                if (root.right != null) {
	                    if (root.right.val == x) {
	                        xParent = root;
	                    }
	                    if (root.right.val == y) {
	                        yParent = root;
	                    }
	                    queue.offer(root.right);
	                }
	                if (xParent != null && xParent == yParent) {
	                    return false;
	                }
	            }
	            if (xParent != null && yParent != null) {
	                return true;
	            }
	        }
	        return false;
	    }
	}

}
