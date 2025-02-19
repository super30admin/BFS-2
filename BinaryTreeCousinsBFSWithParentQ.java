// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class BinaryTreeCousinsBFSWithParentQ {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> parQ = new LinkedList<>();
        q.add(root);
        parQ.add(null);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            TreeNode x_parent = null;
            TreeNode y_parent = null;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                TreeNode currParent = parQ.poll();
                if (x == curr.val && !x_found) {
                    x_found = true;
                    x_parent = currParent;
                }
                if (y == curr.val && !y_found) {
                    y_found = true;
                    y_parent = currParent;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                    parQ.add(curr);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    parQ.add(curr);
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
