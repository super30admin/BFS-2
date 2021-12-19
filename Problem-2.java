// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        boolean xChild = false;
        boolean yChild = false;
        
        while(!q.isEmpty()) {
            int size = q.size();
            xChild = false;
            yChild = false;
            
            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                
                if(curr.left != null && curr.right != null) {
                    if(curr.left.val == x && curr.right.val == y ) {
                        return false;
                    }
                    if(curr.left.val == y && curr.right.val == x) {
                        return false;
                    }
                }
                
                
                if(curr.val== x) {
                    xChild = true;
                }
                
                if(curr.val== y) {
                    yChild = true;
                }
                if(curr.left != null) {
                    q.add(curr.left);
                }
                
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            if(xChild == true && yChild == true) {
                return true;
            }
        }
        return false;
    }
}