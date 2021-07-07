//Time complexity is O(N) as we iterate through all the nodes
//Space Complexity isO(h) i.e the height of the recursion stack if we are considering stack space
//this solution is submitted on leetcode

public class BigN59CousinsBinaryTreeUsingDFS {
	    TreeNode x_parent = null;
	    TreeNode y_parent = null;
	    int x_depth = -1;
	    int y_depth = -2;
	    public boolean isCousins(TreeNode root, int x, int y) {
	        helper(root,x,y,0,null);
	        return x_parent!=y_parent && x_depth==y_depth;
	    }
	    private void helper(TreeNode node, int x, int y, int depth, TreeNode parent){
	        //base case:
	        if(node ==null)
	            return;
	        //Logic:
	        if(node.val == x){
	            x_parent = parent;
	            x_depth = depth;
	        }
	        if(node.val == y){
	            y_parent = parent;
	            y_depth = depth;
	        }
	        helper(node.left,x,y,depth+1,node);
	        helper(node.right,x,y,depth+1,node);
	    }
	}