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
class Problem2 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root.val == x || root.val == y) {
            return false;
        }
        q.add(root);

        while (!q.isEmpty()) {
            int s = q.size();
            TreeNode xp = null, yp = null;

            for (int i = 0; i < s; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x && curr.right.val == y) ||
                            (curr.left.val == y && curr.right.val == x)) {
                        return false;
                    }
                }

                if (curr.left != null) {
                    if (curr.left.val == x) xp = curr;
                    if (curr.left.val == y) yp = curr;
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    if (curr.right.val == x) xp = curr;
                    if (curr.right.val == y) yp = curr;
                    q.add(curr.right);
                }
            }

            if (xp != null && yp != null) {
                return xp != yp;
            }
            if (xp != null || yp != null) {
                return false;
            }
        }
        return false;
    }
}


// Time Complexity: O(N) where N is the number of nodes in the binary tree.
// Space Complexity: O(W) where W is the maximum width of the binary tree.
