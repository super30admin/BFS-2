// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

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

        result = new ArrayList();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level)
    {
        //base
        if(root == null)
            return;

        //if they are equal, we know there is no node in the result for the current level
        //so we add this one, it will be the right most because we are doing right recursive call first
        if(result.size() == level)
            result.add(root.val);

        //right recursive call first and go deeper one level
        dfs(root.right, level+1);
        //we can't ignore left nodes because there maybe such a left node that is visible from the right
        dfs(root.left, level+1);
    }
}
