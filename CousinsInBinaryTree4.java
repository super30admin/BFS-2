import java.util.LinkedList;
import java.util.Queue;

/**
 * Approach: BFS (Breadth-First Search) Level Order Traversal with Sibling Check
 *
 * This solution uses BFS to traverse the binary tree level by level. For each node, it checks if its children are the target nodes x and y (to ensure they are not siblings).
 * At each level, it tracks whether x and y are found. If both are found at the same level and are not siblings, they are cousins.
 *
 * Time Complexity: O(N), where N is the number of nodes in the tree.
 * Space Complexity: O(N), for the queue used in level order traversal.
 */

public class CousinsInBinaryTree4 {

    public boolean isCousins(TreeNode root, int x, int y) {
        boolean xFound = false, yFound = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && node.right != null) {
                    if (node.left.val == x && node.right.val == y) return false;
                    if (node.left.val == y && node.right.val == x) return false;
                }
                if (node.val == x) {
                    xFound = true;
                }
                if (node.val == y) {
                    yFound = true;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (xFound && yFound) return true;
            if (xFound || yFound) return false;
        }
        return false;
    }
}
