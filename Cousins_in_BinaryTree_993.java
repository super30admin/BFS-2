//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None


import java.util.LinkedList;
import java.util.Queue;

class Cousins_in_BinaryTree_993 {

	// DFS
	
	TreeNode x_parent, y_parent;
	int x_depth, y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y); // parameters are root, parent, depth, x and y
        return x_depth == y_depth && x_parent != y_parent;
    }
    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y)
    {
    	// base
    	if(root == null)
    		return;
    	// logic
    	if(root.val == x)
    	{
    		x_parent = parent;
    		x_depth = depth;
    	}
    	if(root.val == y)
    	{
    		y_parent = parent;
    		y_depth = depth;
    	}
    	
    	dfs(root.left, root, depth + 1, x, y);
    	dfs(root.right, root, depth + 1, x, y);
    }

    // BFS
    	  
//    Queue<TreeNode> q = new LinkedList<>();
//    q.add(root);
//    
//    while(!q.isEmpty())
//    {
//    	boolean x_found = false;
//    	boolean y_found = false;
//    	int size = q.size();
//    	
//    	for(int i = 0; i < size; i++)
//    	{
//    		TreeNode currNode = q.poll();
//    		if(currNode.val == x)
//    			x_found = true;
//    		if(currNode.val == y)
//    			y_found = true;
//    		if(currNode.left != null && currNode.right != null)
//    		{
//	    		if((currNode.left.val == x && currNode.right.val == y) || (currNode.left.val == y && currNode.right.val == x))
//	    			return false;
//    		}
//    		if(currNode.left != null)
//                q.add(currNode.left);
//            if(currNode.right != null)
//                q.add(currNode.right);
//    	}
//    	if(x_found && y_found)
//        	return true;
//    }
//    return false;
    
}
