package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Time: O(numNodes)
 * Space: O(numNodes for Queue) + O(numNodes of each level for HashSet) 
 * Leetcode accepted: yes
 * Problems faced: NA
 */
public class Cousins {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1); 
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5); 
        root.right.left = new TreeNode(6); 
        root.right.right = new TreeNode(7); 
        System.out.println(isCousins(root, 4, 6));

	}
	
	public static boolean isCousins(TreeNode root, int x, int y) {
		 if(root == null) return true;
			Queue<TreeNode> q = new LinkedList<>();
			HashSet<Integer> hs = new HashSet<>();
			q.add(root);
			while(!q.isEmpty()) {
				int count = q.size();
				//For each level
				for(int i=0; i<count; i++) {
					TreeNode curr = q.remove();
					if(curr.left != null) q.add(curr.left);
					if(curr.right != null) q.add(curr.right);
					//If x and y belong to same parent, they're not cousins
					if(curr.left != null && curr.right != null) {
						if((curr.left.val == x && curr.right.val == y) ||  (curr.left.val == y && curr.right.val == x)) {
							return false;
						}
					}
				//Take values of nodes of each level in a hashSet
	                hs.add(curr.val);
					if(hs.contains(x) && hs.contains(y)) return true;
				}
	            
				hs.clear();
			}
	        return false;
    }
	
	//Optimized version without using HashSet
	public static boolean isCousinsOptimized(TreeNode root, int x, int y) {
		 if(root == null) return true;
			Queue<TreeNode> q = new LinkedList<>();
			boolean xFound = false, yFound = false;
			q.add(root);
			while(!q.isEmpty()) {
				int count = q.size();
				//For each level
				for(int i=0; i<count; i++) {
					TreeNode curr = q.remove();
					if(curr.left != null) q.add(curr.left);
					if(curr.right != null) q.add(curr.right);
					//If x and y belong to same parent, they're not cousins
					if(curr.left != null && curr.right != null) {
						if((curr.left.val == x && curr.right.val == y) ||  (curr.left.val == y && curr.right.val == x)) {
							return false;
						}
					}
					if(curr.val == x) xFound = true;
					if(curr.val == y) yFound = true;
					if(xFound && yFound) return true;
				}
				xFound = false;
				yFound = false;
			}
	        return xFound && yFound;
   }

}
