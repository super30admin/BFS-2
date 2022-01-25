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
    // Time Complexity : O(n), where n is no of nodes in the tree
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    // Approach - Using BFS
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean x_found = false;
        boolean y_found = false;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                //same parent
                if(null != t.left && null != t.right && t.left.val == x && t.right.val == y) return false;
                if(null != t.left && null != t.right && t.left.val == y && t.right.val == x) return false;

                if(t.val == x) x_found = true;
                if(t.val == y) y_found = true;
                if(null != t.left) {
                    q.add(t.left);
                }
                if(null != t.right) {
                    q.add(t.right);
                }
            }
            if(x_found && !y_found) return false;
            if(!x_found && y_found) return false;
            if(x_found && y_found) return true;
        }
        return false;
    }
}


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
    // Time Complexity : O(n), where n is no of nodes in the tree
    // Space Complexity : O(h), where h is the height of the tree
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    // Approach - Using DFS
    int x_height = 0;
    int y_height = 0;
    TreeNode x_parent = null;
    TreeNode y_parent = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return (x_parent != y_parent && x_height == y_height);
    }

    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y) {
        if(root == null) return;

        if(root.val == x) {
            x_parent = parent;
            x_height = level;
        }

        if(root.val == y) {
            y_parent = parent;
            y_height = level;
        }

        dfs(root.left, root, level+1, x, y);
        dfs(root.right, root, level+1, x, y);
    }
}