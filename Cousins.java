//TC - O(n)
//SC - O(n)
// Did this code successfully run on Leetcode : Yes successfully ran
// Any problem you faced while coding this : No


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cousins {

	 public boolean isCousins(TreeNode root, int x, int y) {
		 
		 boolean res = false;
		 
		 Queue<TreeNode> q = new LinkedList<TreeNode>();
		 q.add(root);
		 boolean x_found =false, y_found =false;
		 
		 while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0; i<size; i++) {
				TreeNode curr = q.poll();
				
				if(curr.val == x) x_found = true;
				if(curr.val == y) y_found = true;
				
				if(curr.left != null && curr.right != null) {
					if(curr.left.val == x && curr.right.val == y) return false;
					if(curr.left.val == y && curr.right.val == x) return false;
				}
				
				if(curr.left !=null) q.add(curr.left);
				if(curr.right !=null) q.add(curr.right);
				
			}
			
			 if(x_found && y_found) return true;
			 if(x_found || y_found) return false;

		 }
		 
		 
		 
		 
		 
		 return false;
		 
	        
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

		Cousins l = new Cousins();
		boolean res = l.isCousins(root,5, 35);
		
	
			System.out.println(res);

	}

}
