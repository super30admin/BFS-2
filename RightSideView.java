// Time Complexity : O(n) where n is the number of nodes in the list
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.*;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList();
        if (root == null)
            return result;
        // logic - preorder traversal dfs
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {
        // base
        if (root == null)
            return;
        // logic
        if (result.size() == level)
            result.add(root.val);
        else
            result.set(level, root.val);
        if (root.left != null)
            dfs(root.left, level + 1);
        if (root.right != null)
            dfs(root.right, level + 1);
    }
}