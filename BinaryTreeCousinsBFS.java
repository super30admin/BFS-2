// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class BinaryTreeCousinsBFS {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (x == curr.val && !x_found) {
                    x_found = true;
                }
                if (y == curr.val && !y_found) {
                    y_found = true;
                }
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y) return false;
                    if (curr.left.val == y && curr.right.val == x) return false;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (x_found && y_found) {
                return true;
            }
            if (x_found || y_found) {
                return false;
            }
        }
        return false;
    }
}
