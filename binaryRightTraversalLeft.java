// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<Integer>();
        if(root == null)
            return result;
        helper(root, 0);
        return result;   
    }
    
    //traversing from right - root - left
    private void helper(TreeNode root, int level){
        //base
        if(root == null) return;
        //logic
        if(result.size() == level)
            result.add(root.val); //new level , adding first right val
        
        helper(root.right, level+1);
        helper(root.left, level+1);
    }
}