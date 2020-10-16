// Time Complexity : O(N)
// Space Complexity : O(M) M - length of longest level in a tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach : Using BFS approach

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
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr = null;
        if(root == null) return false;
        
        queue.add(root);
        while(!queue.isEmpty()){
            boolean x_is_present = false;
            boolean y_is_present = false;
            int qsize = queue.size();
            for(int i = 0; i < qsize; i++){
                curr = queue.poll();
                if(curr.val == x) x_is_present = true;
                if(curr.val == y) y_is_present = true;
                if(curr.left != null && curr.right != null){
                    if((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)){
                    return false;
                }
                }
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            if(x_is_present && y_is_present) return true;
        }
        return false;
    }
}
