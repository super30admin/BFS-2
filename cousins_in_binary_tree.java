import java.util.Queue;
import java.util.Map;
import java.util.HashMap;

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

// Did this code run successfully on Leetcode? : Yes
class Solution {
    // Time Complexity: O(N); n = number of nodes in the input TreeNode
    // Space Complexity: O(N); in worst-case scenario when the x and y values are present at the last level of input TreeNode, 
    // the parent map will store parent of all nodes
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean xFound = false;
        boolean yFound = false;

        while(!queue.isEmpty() && !xFound && !yFound) {
            int size = queue.size();
            TreeNode parent1 = null;
            TreeNode parent2 = null;
            
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if(curr.val == x) {
                    xFound = true;
                    parent1 = parent.get(curr);
                }

                if(curr.val == y) {
                    yFound = true;
                    parent2 = parent.get(curr);
                }

                if(xFound && yFound && parent1 != null && parent2 != null && parent1.val != parent2.val) {
                    return true;
                }

                if(curr.left != null) {
                    parent.put(curr.left, curr);
                    queue.offer(curr.left);
                }

                if(curr.right != null) {
                    parent.put(curr.right, curr);
                    queue.offer(curr.right);
                }
            }
        }

        return false;
    }
}