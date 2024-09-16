package demo;

//Time Complexity : O(n)
//Space Complexity : O(1)( ignoring the recursive stack)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Need to try BFS solution as well

public class CousinsInABinaryTree {

	
	 // Definition for a binary tree node.
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	class Solution {
	    
	    TreeNode x_parent = null;
	    TreeNode y_parent =null;
	    int x_depth = -1;
	    int y_depth = -1;
	    public boolean isCousins(TreeNode root, int x, int y) {
	        
	        helper(root, null, x ,y ,0);
	        return (x_depth == y_depth && x_parent != y_parent );
	    }
	    
	    
	    private void helper(TreeNode root, TreeNode parent, int x, int y, int depth){
	        
	        //edge
	        if(root == null) return;
	        //base
	        if(root.val == x){
	            x_depth = depth;
	            x_parent = parent;
	        }
	        
	        if(root.val == y){
	            y_depth = depth;
	            y_parent = parent;
	        }
	        helper(root.left, root, x,y,depth+1);
	          helper(root.right, root, x,y,depth+1);
	      
	        
	    }
	        
	}
	
}
