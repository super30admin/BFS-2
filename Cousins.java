//Time Complexity : O(n)
// Space Complexity: O(n)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            boolean x_is_found = false;
            boolean y_is_found = false;
            for (int i = 0; i < count; i++) {
                TreeNode node = q.poll();
                if (node.val == x) x_is_found = true;
                if (node.val == y) y_is_found = true;
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) ||
                        (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            if (x_is_found && y_is_found) return true;
            if (x_is_found || y_is_found) return false;
        }
        return false;
    }
}
