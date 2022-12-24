// Time Complexity : O(n)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Using DFS approach, we need to keep track of parent and depth to checkif
 * there are same or not.
 * we check of the root value matches x or y then assign parent and depth with
 * the current root and depth.
 * Do left and right recursive calls
 */
class Solution {
    private TreeNode x_parent;
    private TreeNode y_parent;
    private int x_depth;
    private int y_depth;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return true;
        dfs(root, x, y, 0, null);

        return x_depth == y_depth && x_parent != y_parent;
    }

    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        // base
        if (root == null)
            return;

        // logic
        if (root.val == x) {
            x_parent = parent;
            x_depth = depth;
        }
        if (root.val == y) {
            y_parent = parent;
            y_depth = depth;
        }
        dfs(root.left, x, y, depth + 1, root);

        dfs(root.right, x, y, depth + 1, root);
    }
}

// BFS approach

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Using BFS approach, we need to keep track of parent and child node by using a
 * queue.
 * For every level we check the child value if that matches x or y and then
 * assign boolean value to true and assignt he parent
 * At end we check of the boolean is true and parent don't match
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> q = new LinkedList<>();

        Queue<TreeNode> pq = new LinkedList<>();

        q.add(root);
        pq.add(null);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;

            TreeNode x_parent = null;
            TreeNode y_parent = null;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                TreeNode pCurr = pq.poll();

                if (curr.val == x) {
                    x_found = true;
                    x_parent = pCurr;
                }
                if (curr.val == y) {
                    y_found = true;
                    y_parent = pCurr;
                }

                if (curr.left != null) {
                    q.add(curr.left);
                    pq.add(curr);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    pq.add(curr);
                }
            }
            if (x_found && y_found) {
                return x_parent != y_parent;
            }
            if (x_found || y_found) {
                return false;
            }
        }

        return false;
    }
}
