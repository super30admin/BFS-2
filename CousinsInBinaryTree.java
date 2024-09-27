/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity : O(n)
// Space Complexity : O(n)

// This solution uses BFS and queue


class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        // root matches X or Y return false;

        if(root.val == x || root.val == y) return false;

        TreeNode parentX = null, parentY = null;
        int levelX = -1, levelY = -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0; // depth

        while(!queue.isEmpty()) {
        	int countNodesLevel = queue.size();

        	for(int i = 0; i < countNodesLevel; i++) {
        		TreeNode currentNode = queue.poll();

        		if(currentNode.left != null) {
        			if(currentNode.left.val == x) {
        				parentX = currentNode;
        				levelX = depth;
        			} else if(currentNode.left.val == y) {
        				parentY =currentNode;
        				levelY = depth;
        			}
        			queue.add(currentNode.left);
        		}

        		if(currentNode.right != null) {
        			if(currentNode.right.val == x) {
        				parentX = currentNode;
        				levelX = depth;
        			} else if(currentNode.right.val == y) {
        				parentY =currentNode;
        				levelY = depth;
        			}
        			queue.add(currentNode.right);
        		}

        	}
        	depth++;
        }
       
       // parent X and Y, levelX and Y
        if(parentX != parentY && levelX == levelY) {
        	return true;
        }

        return false;
       
    }
  
}