import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        // DFS solution
        result = new ArrayList<>();
        dfs(root, 0);
        return result;

    }

    private void dfs(TreeNode root, int lvl) {
        // base
        if (root == null)
            return;

        // logic
        if (lvl == result.size()) {
            result.add(root.val);
        }
        dfs(root.right, lvl + 1); // travelling right first to obtain only right nodes in the result.
        dfs(root.left, lvl + 1);
    }
}