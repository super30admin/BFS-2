// Time Complexity : O(N)
// Space Complexity : O(N) //actual queue might have max of n/2 elements at last level
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Do BFS travel and add last element at each level to list.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class RightSideViewBinaryTreeBFS {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root==null) return result;
		Queue<TreeNode> queue= new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int count=queue.size();	
			for(int i=0;i<count;i++) {
				TreeNode node = queue.poll();
				if(i==count-1)
					result.add(node.val);					
				if(node.left!=null)queue.add(node.left);
				if(node.right!=null)queue.add(node.right);
			}
			
		}
		
		return result;
		
	}
	public static void main(String[] args) {
		TreeNode root= new TreeNode(1);
		root.right= new TreeNode(2);
		root.right.right= new TreeNode(3);
		root.right.right.right= new TreeNode(5);
		root.right.right.right.right= new TreeNode(4);
		System.out.println(new RightSideViewBinaryTreeBFS().rightSideView(root));
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
