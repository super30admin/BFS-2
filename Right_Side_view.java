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
    //Time O(N)
    //Space O(H)
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        helper(root , 0);
        return result;
    }
    public void helper(TreeNode root, int depth)
    {
        //base
        if(root == null)
        {
            return;
        }
        //logic
        if(depth == result.size())
        {
            result.add(root.val);
        }
        helper(root.right , depth+1);
        helper(root.left , depth+1);
    }
}