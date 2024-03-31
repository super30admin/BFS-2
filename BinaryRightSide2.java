// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/binary-tree-right-side-view/description/
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
        result = new ArrayList<>();
        if(root==null) return result;
        helper(root,0);
        return result;
    }
    public void helper(TreeNode root, int level){
         if(root==null) return;

         if(result.size()==level){
            result.add(root.val);
         }
         helper(root.right,level+1);
          helper(root.left,level+1);
    }
}
