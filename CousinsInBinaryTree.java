package s30Coding;

//Time Complexity :- O(n) where n is the nodes in the Tree

//Space Complexity :- O(h) height of recursive tree(recursive stack)

//LeetCode :- Yes
//Logic :- DFS traversal

public class CousinsInBinaryTree {

	public class TreeNode {
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

	    int x_depth, y_depth;
	    TreeNode x_parent, y_parent;
	    public boolean isCousins(TreeNode root, int x, int y) {
	        dfs(root, x,y,0, null);
	        return x_depth == y_depth && x_parent!= y_parent;
	    }
	    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent ){
	        //base case
	        if(root == null) return;
	        //logic
	        if(root.val == x){
	            x_depth = depth; 
	            x_parent = parent;
	        }
	        if(root.val == y){
	            y_depth = depth; 
	            y_parent = parent;
	        }
	        dfs(root.left,x,y,depth+1,root);
	        dfs(root.right,x,y,depth+1,root);
	        
	    }
}
