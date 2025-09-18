// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
We perform DFS and traverse to the right child before the left and add the right node to the result list
We add a node to the list when the size of list is same as the depth of the tree
End the recursion when root left and right has no further nodes
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
        this.result = new ArrayList<>();
        if (root == null) return result;
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        //base
        if(root == null) return;
        //logic
        if(result.size() == level) {
            //Need to add corresponding to that level
            result.add(root.val);
        }
        helper(root.right, level+1);
        helper(root.left, level+1);
    }
}
