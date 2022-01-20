package bfs2;

import java.util.LinkedList;
import java.util.Queue;

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
	
	//BFS
	//Time Complexity : O(n), where n is the elements of tree, in worst case
	//Space Complexity : O(n), for queue
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            boolean xFound = false;
            boolean yFound = false;
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                
                if(curr.left != null && curr.right != null)
                    if(curr.left.val == x && curr.right.val == y) return false;
                
                if(curr.left != null && curr.right != null)
                    if(curr.left.val == y && curr.right.val == x) return false;
                
                if(curr.val == x) xFound = true;
                if(curr.val == y) yFound = true;
                
                if(xFound && yFound)
                    return true;
                
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
            }
        }
        
        return false;
    }
	
	//DFS
	//Time Complexity : O(n), where n is the height of tree
	//Space Complexity : O(n), for recursion stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	TreeNode x_parent = null;
    TreeNode y_parent = null;
    int x_height = 0;
    int y_height = 0;
    public boolean isCousins1(TreeNode root, int x, int y) {
        helper(root, null, x, y, 0);
        return x_height == y_height && x_parent != y_parent;
    }
    
    private void helper(TreeNode root, TreeNode parent, int x, int y, int height) {
        // base
        if(root == null)
            return;
        
        // logic
        if(root.val == x) {
            x_parent = parent;
            x_height = height;
        }
        
        if(root.val == y) {
            y_parent = parent;
            y_height = height;
        }
        
        helper(root.left, root, x, y, height + 1);
        helper(root.right, root, x, y, height + 1);
    }
}
