// Time Complexity : O(n)
// Space Complexity : O(n) recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        traverse(root, 0); // initial call
        return result;
    }

    public void traverse(TreeNode root, int level){
        if(root == null){ // base case
            return;
        }
        if(level == result.size()){ // check to see if this is the right most element of that level
            result.add(root.val); // adding to the array
        }
        traverse(root.right, level+1); // move right
        traverse(root.left, level+1); // move left
    }
}