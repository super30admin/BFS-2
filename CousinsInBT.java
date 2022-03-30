//Time Complexity : O(n)
//Space Complexity : O(H)
public class CousinsInBT {	
	/**Definition for binary tree node.**/
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {this.val = val;}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	 
	/**Approach: DFS**/
	TreeNode xParent;
	TreeNode yParent;
	int xHeight;
	int yHeight;
	public boolean isCousins(TreeNode root, int x, int y) {
		dfs(root,x,y,0,null);
		return (xHeight==yHeight && xParent!=yParent);
	}
    
	private void dfs(TreeNode root, int x, int y, int level, TreeNode parent) {
		//base
		if(root==null) return;
		
		//logic
		if(x==root.val) {
			xHeight=level;
			xParent=parent;
		}
		if(y==root.val) {
			yHeight=level;
			yParent=parent;
		}
		dfs(root.left,x,y,level+1,root);
		dfs(root.right,x,y,level+1,root);
	}

	// Driver code to test above 
	public static void main(String args[]) {
		CousinsInBT ob = new CousinsInBT();
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),	new TreeNode(3, new TreeNode(5), new TreeNode(6)));
		int x = 4;
		int y = 3;

		System.out.print("If " + x + " and " + y + " are cousins in given tree? " + ob.isCousins(root, x, y));
	}
}
