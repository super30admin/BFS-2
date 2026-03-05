// Time: O(n)
// Space: O(n)
// Ran succesfully on Leetcode: yes
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        // initialize queue
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            // reinitialize present for every level
            int size = q.size();
            boolean x_present = false;
            boolean y_present = false;
            // iterate over the snapshot for the level by level
            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();
                // if same parent then siblings
                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x && curr.right.val == y) ||
                            (curr.left.val == y && curr.right.val == x)) {

                        return false;
                    }
                }

                if (curr.val == x) x_present = true;
                if (curr.val == y) y_present = true;

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            // for each level finally check if both are present
            if (x_present && y_present) return true;
            if (x_present || y_present) return false;
        }

        return false;
    }

}