

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//BFS approach

public class RightSideView {
	    public List<Integer> rightSideView(TreeNode root) {
		        // List<List<Integer>> result = new ArrayList<>();
		        
	            List<Integer> list = new  ArrayList<>();
	        if (root == null) return list;
		        Queue<TreeNode> q = new LinkedList<>();
		        q.add(root);

		        while(!q.isEmpty()){
		            int size = q.size();
		           

		            for(int i = 0; i < size; i++ ){
		                TreeNode curr = q.poll();
		                if(i == size-1){
	                    list.add(curr.val);
	                    }
		                if(curr.left!= null) q.add(curr.left);
		                if(curr.right!= null) q.add(curr.right);
		            }
		            
		        }
		        return list;
		    }
		}
