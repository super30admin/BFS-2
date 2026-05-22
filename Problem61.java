// Time Complexity : O(N)
// Space Complexity : O(h)

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean x_found = false; boolean y_found = false;

        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if(curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y) return false;
                    if (curr.left.val == y && curr.right.val == x) return false;
                }

                if (curr.val == x) {
                    x_found = true;
                }

                if (curr.val == y) {
                    y_found = true;
                }

                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            if (x_found && y_found) return true;
            if (x_found || y_found) return false;
        }

        return false;
    }
}