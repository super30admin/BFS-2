//https://leetcode.com/submissions/detail/617859764/
//Time: O(n)
//Space: O(n)
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
    
    List<Integer> rightView;
    public List<Integer> rightSideView(TreeNode root) {
        int level = 0;
        rightView = new ArrayList<>();
        dfs(root, 0);
        return rightView;
    }
    
    private void dfs(TreeNode root, int level) {
        
        if(root == null) {
            return;
        }
        
        if(rightView.size() == level) {
            rightView.add(root.val);   
        }        
        
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
    
}