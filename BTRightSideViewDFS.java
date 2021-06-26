//Time Complexity - O(n)
//Space complexity - O(h) - height of the tree

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
    
      if(root == null) return result;
        
      dfs(root, 0);
      return result;
    }
  
    private void dfs(TreeNode root, int level) {
       //base
      if(root == null) return;
      //logic
      if(result.size() == level) {
        //if level and size are not equal add the current node val to result
        result.add(root.val);
      }
      // go right and add the value in result
      dfs(root.right, level+1);
      dfs(root.left, level +1);
    }
} 