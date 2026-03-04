import java.util.*;

// BFS O(n) time, O(n) space
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean isXPresent = false;
        boolean isYPresent = false;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.val == x) {
                    isXPresent = true;
                }
                if (curr.val == y) {
                    isYPresent = true;
                }

                if (curr.left != null && curr.right != null) {
                    // they are siblings not cousins
                    if (curr.left.val == x && curr.right.val == y) return false; 
                    if (curr.left.val == y && curr.right.val == x) return false; 
                }

                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            // after each level check if both found or just one found
            if (isXPresent && isYPresent) return true;    
            if (isXPresent || isYPresent) return false;
        }
        return true;
    }
}