package Nov11;

import java.util.LinkedList;
import java.util.Queue;

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

class CousinsInBinaryTreeBFS {
    
/*
     Time Complexity: O(n)
     Since in worst case scenario, we will iterate through all n nodes of the tree to find nodes with x and y.
    
     Space Complexity: O(n/2) ~= O(n) 
     The BFS queue will have max of n/2 leaf nodes if we traverse till the last level of the tree. 
   
     Did this code successfully run on Leetcode : Yes
    
     Any problem you faced while coding this : No
        
     Approach: 
     BFS used to traverse the given tree till nodes with both x and y values found.
               
*/ 
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        // edge
        if (root == null) {
            return false;
        }
        
        queue.add(root);
        while (!queue.isEmpty()) {
            
            // reset found flags for x and y after processing one level of the tree
            boolean x_found = false;
            boolean y_found = false;
            
            // processing a level of the tree
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode curr = queue.poll();
                
                // if x and y nodes found at current tree level, respective found flags set to true 
                if (curr.val == x) {
                    x_found = true;
                } 
                if (curr.val == y) {
                    y_found = true;
                }
                
                // if left and right child of current node has values x and y, then common parent for them is current node, hence cannot be cousins, so return false from here itself.
                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)) {
                        return false;
                    }
                }
    
                // if left and right child not null, adding them to queue for further processing in the next iteration of while loop
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            
            // if both x and y found in the tree and they dont have a common parent, since the if condition at line 65 has already failed, or else control would have returned false from there itself 
            if (x_found && y_found) {
                return true;
            }
        }
        return false;
    }
    
}