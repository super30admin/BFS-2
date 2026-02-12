// Time Complexity :O(N)
// Space Complexity :O(H)..H= height of the tree 
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no 

// Your code here along with comments explaining your approach
// We do a modified pre-order DFS (root -> right -> left) to ensure we visit the rightmost nodes first at each level.  
// When visiting a new level for the first time, we append that node’s value to the result.
// This gives the right-side view of the binary tree.

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result, 0);
        return result;   
    }
    private void helper(TreeNode root, List<Integer> result, int level){
        //base
        if (root==null){
            return;
        }

        //logic
        if (result.size() == level){
            result.add(root.val);
        }

        helper(root.right,result,level+1);
        helper(root.left, result, level+1);
    }
}