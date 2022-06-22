/* Time Complexity : O(n), n-no of nodes
 * Space Complexity : O(h), h-height of the tree, recursive stack space
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
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
        result = new ArrayList<>();
        //null
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        //base
        if(root == null) return;
        //logic
        if(level == result.size()){
            result.add(root.val);
        } else {
            result.set(level, root.val);
        }
        //left first then right
        dfs(root.left, level + 1);
        //st.pop()
        dfs(root.right, level + 1);
        //st.pop()
    }
}
