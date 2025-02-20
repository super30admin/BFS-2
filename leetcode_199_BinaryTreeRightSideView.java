// Time Complexity : O(n)
// Space Complexity : O(n)
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
      public List<Integer> rightSideView(TreeNode root) {
       List<Integer> result = new ArrayList<>();
       dfs(root, result, 0);
       return result;
   }

   public void dfs(TreeNode root,List result,int level){
       if(root == null) return;

       if(level == result.size()){
        result.add(root.val);
       }
        // right first, then left, if we do not, then need to add else statement above.
       dfs(root.right,result,level + 1);
       dfs(root.left,result,level + 1);
   }
}