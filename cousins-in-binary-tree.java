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
    // dfs, TC = O(N) as we are visiting each node, SC = O(H) rec stack space
    TreeNode x_parent, y_parent;
    int x_level, y_level;
    public boolean isCousins(TreeNode root, int x, int y) {
        // null
        if(root == null) return false;
        dfs(root, null, 0, x, y);
        return (x_parent != y_parent) && (x_level == y_level);
    }
    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y) {
        // base
        if(root == null) return;
        // logic
        if(root.val == x) {
            x_parent = parent; x_level = level;
        }
        if(root.val == y) {
            y_parent = parent; y_level = level;
        }
        // optimization, call only when it is needed
        if(x_parent == null || y_parent == null) dfs(root.left, root, level + 1, x, y);
        if(x_parent == null || y_parent == null) dfs(root.right, root, level + 1, x, y);
    }

// bfs / prefer dfs, TC = O(N), SC = O(N)
    // public boolean isCousins(TreeNode root, int x, int y) {
    //     // null
    //     if(root == null) return false;
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.add(root);
    //     while(!q.isEmpty()) {
    //         int size = q.size();
    //         boolean x_flag = false, y_flag = false;
    //         for(int i = 0; i < size; i++) {
    //             TreeNode curr = q.poll();
    //             if(curr.val == x) x_flag = true; // checking curr value against x & y
    //             if(curr.val == y) y_flag = true;
    //             if(curr.left != null && curr.right != null) { // checking for the same parent
    //                 // checking parent if same, return false & dont add it to q
    //                 if(curr.left.val == x && curr.right.val == y) return false;
    //                 if(curr.left.val == y && curr.right.val == x) return false;
    //             }
    //             if(curr.left != null) q.add(curr.left); // means both are at same level & we have checked for their parents that they are not same
    //             if(curr.right != null) q.add(curr.right);
    //         }
    //         if(x_flag && y_flag) return true;
    //         if(x_flag || y_flag) return false;
    //     }
    //     return false;
    // }
}