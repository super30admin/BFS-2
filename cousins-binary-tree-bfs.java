//TC is O(n)
//SC is O(n) it is the width of the tree
class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null || x == 0 || y == 0 || x == y) {
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            boolean x_found = false;
            boolean y_found = false;

            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.val == x) {
                    x_found = true;
                }

                if (curr.val == y) {
                    y_found = true;
                }

                if (curr.left != null && curr.right != null) {
                    // this is checking that they both don't have the same parent
                    if (curr.left.val == x && curr.right.val == y) {
                        return false;
                    }

                    if (curr.left.val == y && curr.right.val == x) {
                        return false;
                    }
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }

                if (x_found && y_found) {
                    // they are both found in the same level.
                    // we have also checked that the parent is not same above
                    return true;
                }
            }
        }

        return false;
    }

}