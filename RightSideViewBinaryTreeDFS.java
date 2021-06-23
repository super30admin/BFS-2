// Time Complexity : O(N)
// Space Complexity : O(H) //stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Do DFS travel and add right node val into list.
 */

import java.util.ArrayList;
import java.util.List;


public class RightSideViewBinaryTreeDFS {
	List<Integer> result = new ArrayList<>();
	public List<Integer> rightSideView(TreeNode root) {
		if(root==null) return result;
		
		dfs(root,0);
		
		return result;
		
	}
	private void dfs(TreeNode root,int level) {
		if(root==null) return;
		if(result.size()==level) {
			result.add(root.val);
		}
		
		dfs(root.right,level+1);
		dfs(root.left,level+1);
	}
	
	public static void main(String[] args) {
		TreeNode root= new TreeNode(1);
		root.right= new TreeNode(2);
		root.right.right= new TreeNode(3);
		root.right.right.right= new TreeNode(5);
		root.right.right.right.right= new TreeNode(4);
		System.out.println(new RightSideViewBinaryTreeDFS().rightSideView(root));
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
