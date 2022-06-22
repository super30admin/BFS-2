/* Time Complexity: O(n), n no of nodes
 * Space Complexity: O(h), for recursive stack
 * Did this code successfully run on Leetcode : yes
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
    TreeNode x_parent;
    TreeNode y_parent;
    int x_ht;
    int y_ht;
    public boolean isCousins(TreeNode root, int x, int y) {
        //null
        if(root == null) return false;
        dfs(root, null, 0, x, y);
        return x_parent != y_parent && x_ht == y_ht;
    }
    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y){
        //base
        if(root == null) return;
        //logic
        if(root.val == x){
            x_parent = parent;
            x_ht = level;
        }
        if(root.val == y){
            y_parent = parent;
            y_ht = level;
        }
        //optimization
        if(x_parent == null || y_parent == null)
            dfs(root.left, root, level + 1, x, y);
        //st.pop() 
        if(x_parent == null || y_parent == null)
            dfs(root.right, root, level + 1, x, y);
        //st.pop()
    }
}
