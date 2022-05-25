// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class CousinBT {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            boolean x_found = false, y_found = false;
            for (int i = 0; i < sz; i++) {
                TreeNode node = q.poll();
                if (node.val == x)
                    x_found = true;
                if (node.val == y)
                    y_found = true;

                if (node.left != null && node.right != null && (node.left.val == x || node.left.val == y)
                        && (node.right.val == x || node.right.val == y)) {
                    return false;
                }

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            if (x_found && y_found) {
                return true;
            }
        }
        return false;
    }
}
