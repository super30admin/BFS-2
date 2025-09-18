// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
In the queue we check for the current nodes and left and right child if equals to x and y and return false as they are siblings 
If not we check if the value of current popped node is equal to x or y if yes we return root
We keep adding roots left and right child to the queue
*/
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
        boolean x_found = false, y_found = false;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0;i< size;i++) {
                TreeNode curr = q.poll();
                //check for the parent node if same they are considered as siblings return false
                if(curr.left != null && curr.right != null)  {
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }
                
                //check if the nodes are x and y
                if(curr.val == x) {
                    x_found = true;
                }
                if(curr.val == y) {
                    y_found = true;
                }
                
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }

            }
            if(x_found && y_found) return true;
            if(x_found || y_found) return false;
        }
        return true;
        
    }
}
