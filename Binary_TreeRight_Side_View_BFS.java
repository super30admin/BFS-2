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
        if(root==null)
            return result;
        
        helper(root,0);
        return result;
    }
    
    private void helper (TreeNode root, int level) {
        // base
        if(root == null) return;
        
        // logic
        if(result.size()==level)
            result.add(root.val);

        helper(root.right, level+1);
        helper(root.left, level+1);
    }
}

