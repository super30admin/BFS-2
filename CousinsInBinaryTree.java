//TC: O(n)
//SC: O(n)
//approach: BFS


import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean xFound = false;
            boolean yFound = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.val == x) xFound = true;
                if (node.val == y) yFound = true;
                if (node.left != null && node.right != null) {
                    if (node.left.val == x && node.right.val == y) return false;
                    if (node.left.val == y && node.right.val == x) return false;
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            if (xFound && yFound) return true;
        }
        return false;
    }
}
