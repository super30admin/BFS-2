// TC : O(n)
// SC : O(h)
// Ran on LC : Yes
// Problems : None.
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
class Solution {
	List<Integer> res;
	public List<Integer> rightSideView(TreeNode root) {
		 res = new ArrayList<>();
		 if(root == null) return res;
		 
		 Queue<TreeNode> q = new LinkedList<>();
		 
		 q.add(root);
		 
		 while(!q.isEmpty()) {
			  int size = q.size();
			  for(int i = 0; i < size; i++) {
					TreeNode curr = q.poll();
					if(i == 0) {
						 res.add(curr.val);
					}
					if(curr.right != null) q.add(curr.right);
					if(curr.left != null) q.add(curr.left);
			  }
		 }
		 // dfs(root, 0);
		 return res;
	}
	
	//DFS approach
	private void dfs(TreeNode root, int depth) {
		 //base
		 if(root == null) return;
		 
		 //logic
		 if(depth == res.size()) res.add(root.val);
		 dfs(root.right, depth + 1);
		 dfs(root.left, depth + 1);
		 
	}
}