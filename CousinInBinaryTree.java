// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class CousinInBinaryTree {
    class Solution {
        TreeNode parent_x;
        TreeNode parent_y;
        int depth_x;
        int depth_y;
        public boolean isCousins(TreeNode root, int x, int y) {
            helper(root, null, x, y, 0);
            return parent_x != parent_y && depth_x == depth_y;
        }

        private void helper(TreeNode root, TreeNode parent, int x, int y, int level){
            if(root == null)
                return;
            if(root.val == x){
                parent_x = parent;
                depth_x = level;
            }
            if(root.val == y){
                parent_y = parent;
                depth_y = level;
            }

            helper(root.left, root, x, y, level+1);
            helper(root.right, root, x, y, level+1);
        }
    }
}
