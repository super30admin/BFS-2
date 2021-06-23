// Time Complexity : O(N) 
// Space Complexity : O(H) //stack space  
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Run DFS on tree.
 * 2. Save both elements level and parents.
 * 3. return both parents should not be same and levels should be same.
 */

public class CousinsBinaryTreeDFS {
	int xlevel;
	int ylevel;
	TreeNode xparent;
	TreeNode yparent;
	public boolean isCousins(TreeNode root, int x, int y) {

		if (root == null)
			return false;
		if (root.val == x || root.val == y)
			return false;
		
		dfs(root,null,0,x,y);

		return xparent!=yparent && xlevel==ylevel;
		
	}
	
	private void dfs(TreeNode root,TreeNode parent,int level,int x,int y) {
		if(root==null || (xparent!=null && yparent!=null)) return;
		
		if (root.val == x) {
			xlevel = level;
			xparent=parent;
		}
		if (root.val == y) {
			ylevel=level;
			yparent=parent;
		}
		
		dfs(root.left,root,level+1,x,y);
		dfs(root.right,root,level+1,x,y);
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
