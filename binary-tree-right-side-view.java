// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    // BFS, TC = O(N), SC = O(N) // q if leaf level has n / 2 nodes
    // List<Integer> result;
    // public List<Integer> rightSideView(TreeNode root) {
    //     // null
    //     result = new ArrayList<>();
    //     if(root == null) return result;
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.add(root);
    //     while(!q.isEmpty()) {
    //         int size = q.size();
    //         for(int i = 0; i < size; i++) {
    //             TreeNode curr = q.poll();
    //             if(i == (size - 1)) result.add(curr.val); // for left view i == 0
    //             if(curr.left != null) q.add(curr.left);
    //             if(curr.right != null) q.add(curr.right);
    //         }
    //     }
    //     return result;
    // }

    // DFS, TC = O(N),SC = O(H)
    private List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        // null
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level) {
        // base
        if(root == null) return;
        // logic
        // just overwrite at the level with the right most result
        if(result.size() == level) result.add(root.val);
        else result.set(level, root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
        // if we'r calling right first so no need of else part, as at the level, first rigth is written
        // result.set(level, root.val);
    }
}