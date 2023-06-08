// Time Complexity: O(N) where N is the number of nodes in the tree
// Space Complexity: O(H) where H is the height of the tree

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
class Solution1 {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        //base case
        if(root == null) {
            return;
        }
        if( result.size() == level) {
            result.add(root.val);
        }
        helper(root.right, level+1);
        helper(root.left, level+1);
    }
}