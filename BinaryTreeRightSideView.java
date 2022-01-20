package bfs2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
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
	//Time Complexity : O(n), where n is the nodes of tree
	//Space Complexity : O(n), for queue
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                
                if(i == size - 1)
                    res.add(curr.val);
                
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
            }
        }
        
        return res;
    }
	
	//DFS with left first
	//Time Complexity : O(h), where h is the height of tree
	//Space Complexity : O(n), for recursion stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper1(root, result, 0);
        return result;
    }
    
    private void helper1(TreeNode root, List<Integer> result, int level) {
        // base
        if(root == null)
            return;
        
        // logic
        if(level == result.size())
            result.add(root.val);
        else
            result.set(level, root.val);
        
        helper1(root.left, result, level + 1);
        helper1(root.right, result, level + 1);
    }
	
	//DFS with right first
	//Time Complexity : O(h), where h is the height of tree
	//Space Complexity : O(n), for recursion stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper2(root, result, 0);
        return result;
    }
    
    private void helper2(TreeNode root, List<Integer> result, int level) {
        // base
        if(root == null)
            return;
        
        // logic
        if(level == result.size())
            result.add(root.val);
        
        helper2(root.right, result, level + 1);
        helper2(root.left, result, level + 1);
    }
}
