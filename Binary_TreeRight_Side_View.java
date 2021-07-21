// 199. Binary Tree Right Side View - https://leetcode.com/problems/binary-tree-right-side-view/
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did it run on Leetcode? : Yes
// Any problems? : No

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
    private List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return list;
    }
    
    private void helper(TreeNode root, int level){
        if(root == null)
            return;
        if(list.size() > level)
            list.set(level, root.val);
        else
            list.add(root.val);
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}