//TC: O(n) 
//SC: O(n)


class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            boolean depth_x = false;
            boolean depth_y = false;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.val == x) {
                    depth_x = true;
                }
                if (curr.val == y) {
                    depth_y = true;
                }
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y)
                        return false;
                    if (curr.left.val == y && curr.right.val == x)
                        return false;
                }
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            if (depth_x && depth_y)
                return true;
            if (depth_x || depth_y)
                return false;
        }
        return false;
    }
}