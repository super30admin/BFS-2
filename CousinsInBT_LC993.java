//Time Complexity	O(n)
//Space Complexity	O(n)


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
class CousinsInBT_LC993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            boolean xFound = false, yFound = false;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Check if current node's children are x and y (siblings)
                if (current.left != null && current.right != null) {
                    if ((current.left.val == x && current.right.val == y) ||
                        (current.left.val == y && current.right.val == x)) {
                        return false; // Siblings, not cousins
                    }
                }

                if (current.left != null) {
                    queue.offer(current.left);
                    if (current.left.val == x) xFound = true;
                    if (current.left.val == y) yFound = true;
                }

                if (current.right != null) {
                    queue.offer(current.right);
                    if (current.right.val == x) xFound = true;
                    if (current.right.val == y) yFound = true;
                }
            }
            if (xFound && yFound) return true;
            if (xFound || yFound) return false;
        }
        return false;
    }
}