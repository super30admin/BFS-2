/***********************************************BFS***********************************************/
//Time Complexity :O(n)
//Space Complexity : O(n) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

import java.util.*;
// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class CousinsIn_BinaryTreeBFS {
	public boolean isCousins(TreeNode root, int x, int y) {
		if(root == null)
			return false;

		boolean x_found  = false, y_found = false;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while(!q.isEmpty()){

			int size = q.size();

			for(int i=0; i<size; i++){
				TreeNode curr = q.poll();

				if(curr.left != null && curr.right != null){
					if((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val ==x))
						return false;
				}
				if(curr.val == x)
					x_found = true;

				if(curr.val == y)
					y_found = true;

				if(curr.left != null)
					q.add(curr.left);

				if(curr.right != null)
					q.add(curr.right);
			}
			if(x_found && y_found)
				return true;
			if(x_found || y_found)
				return false;
		}
		return false;
	}
}

/***********************************************DFS***********************************************/
//Time Complexity :O(n), n is the number of nodes in the tree.
//Space Complexity : O(h), h is the height of the tree.
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/* Using DFS, if x and y their respective depths and parents. if the two exist
 * at same depth with different parent's return True, else return False.*/

class CousinsIn_BinaryTreeDFS {
	TreeNode x_parent;	// to keep track of parent of x and y
	TreeNode y_parent;
	int x_depth; int y_depth;	// to record depth at which x and y was found
	public boolean isCousins(TreeNode root, int x, int y) {
		if(root == null)
			return false;

		dfs(root, 0, null, x, y);	// calling dfs on root for parent null and depth 0

		return x_parent != y_parent && x_depth == y_depth;	// if the depth is same and parents are not
	}

	private void dfs(TreeNode root, int level, TreeNode parent, int x, int y){
		//base
		if(root == null)
			return;

		if(root.val == x){	// if value at root is x
			x_parent = parent;	// save the depth at which it was found and its parent
			x_depth = level;
		}
		if(root.val == y){	// if value at root is y
			y_parent = parent;	// save the depth at which it was found and its parent
			y_depth = level;
		}

		dfs(root.left, level + 1, root, x, y);
		//st.pop() happens here
		dfs(root.right, level + 1, root, x, y);
	}
}
