package BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Time: O(n)
 * Space: O(n)
 * Leetcode accpeted: yes
 * Problems faced: NA
 */
public class ZigZagLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1); 
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.right.right = new TreeNode(5); 
        System.out.println(zigzagLevelOrder(root));
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) return result;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode curr;
		//Reverse this flag for every alternate level
		boolean isReverse = false;
		while(!q.isEmpty()) {
			int count = q.size();
			List<Integer> set = new ArrayList<Integer>();
			for(int i=0; i<count; i++) {
				curr = q.remove();
				if(curr.left != null)	q.add(curr.left);
				if(curr.right != null)	q.add(curr.right);
				set.add(curr.val);
			}
			if(isReverse) Collections.reverse(set);
			result.add(set);
			isReverse = !isReverse;
		}
		return result;
	}
}
