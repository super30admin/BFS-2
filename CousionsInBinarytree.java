// Time complexity - O(n)
// Space complexity - O(n)
//Did you face any issues - No
// solved on leetcod e- yes

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            boolean xpresent = false, ypresent = false;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // Check if x and y are siblings (share the same parent)
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) ||
                        (node.left.val == y && node.right.val == x))
                        return false;
                }

                // Check if x or y is found at current level
                if (node.val == x) xpresent = true;
                if (node.val == y) ypresent = true;

                // Add children to queue
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            // After processing the current level:
            if (xpresent && ypresent) return true; // Cousins found
            if (xpresent || ypresent) return false; // Only one found at this level → not cousins
        }

        return false; // Neither found
    }
}
