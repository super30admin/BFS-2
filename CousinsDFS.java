
// Time Complexity :O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
	
	TreeNode(int val){
		this.val=val;
	}
	
}
public class CousinsDFS {
	
	
	int x_depth= 0, y_depth = 0;
	TreeNode x_parent = null,  y_parent = null;
	
	private boolean isCousins(TreeNode root, int x, int y){
		
		if(root == null)
			return false;
		
		dfs(root, x ,y, 0, root);
		
		return x_depth == y_depth && x_parent != y_parent;
	
	
	}
	
	private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
		
		if(root == null)
			return;
		
		if(root.val == x) {
			x_depth = depth+1;
			x_parent = parent;
		}
		if(root.val == y) {
			y_depth = depth+1;
			y_parent = parent;
		}
		
		dfs(root.left, x,y,depth+1,root);
		dfs(root.right, x,y,depth+1,root);
		
		
	}
	

	public static void main(String[] args) {

		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);

		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(12);

		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(35);

		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(6);

		root.left.right.left = new TreeNode(11);
		root.left.right.right = new TreeNode(15);

		root.right.right.left = new TreeNode(32);
		root.right.right.right = new TreeNode(40);

		CousinsDFS l = new CousinsDFS();
		boolean res = l.isCousins(root,5, 40);
		
	
			System.out.println(res);


	}

}
