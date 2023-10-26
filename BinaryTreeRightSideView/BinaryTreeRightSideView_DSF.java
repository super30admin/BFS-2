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

/* Time Complexity : O(n) 
 *  n - length of the tree */
/* Space Complexity : O(h)
 *  h - height of the tree */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//DSF solution

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);//node, level
        return result;
    }

    private void dfs(TreeNode root, int level){
        //base condition
        if(root == null) return;
        //logic
        if(level == result.size()){
            result.add(root.val);
        }
        level++;
        dfs(root.right, level);
        dfs(root.left, level);
    }
}