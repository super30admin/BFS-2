package week5.day2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution3 {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(i==size-1)
                    result.add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
        return result;
    }
}

public class RightSideViewTree_BFS {

	public static void main(String[] args) {
		// Create a sample binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		Solution3 solution = new Solution3();

		List<Integer> result = solution.rightSideView(root);
		System.out.println(result);

		
	}
}


/*
 * class TreeNode { int val; TreeNode left; TreeNode right;
 * 
 * TreeNode() { }
 * 
 * TreeNode(int val) { this.val = val; }
 * 
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
