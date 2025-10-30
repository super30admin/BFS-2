import java.util.LinkedList;
import java.util.Queue;

/**
 * Approach: BFS (Breadth-First Search) Level Order Traversal
 *
 * This solution uses BFS to traverse the binary tree level by level, keeping track of each node's parent.
 * For each level, it checks if both target nodes x and y are found and ensures they have different parents (not siblings).
 * If both are found at the same level with different parents, they are cousins.
 *
 * Time Complexity: O(N), where N is the number of nodes in the tree.
 * Space Complexity: O(N), for the queue used in level order traversal.
 */

public class CousinsInBinaryTree3 {

    public boolean isCousins(TreeNode root, int x, int y) {
        boolean xFound = false, yFound = false;
        TreeNode xParent = null, yParent = null;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> parentQueue = new LinkedList<>();
        queue.add(root);
        parentQueue.add(null);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode parent = parentQueue.poll();
                if (node.val == x) {
                    xFound = true;
                    xParent = parent;
                }
                if (node.val == y) {
                    yFound = true;
                    yParent = parent;
                }
                if (node.left != null) {
                    queue.add(node.left);
                    parentQueue.add(node);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    parentQueue.add(node);
                }
            }
            if (xFound && yFound) return xParent!=yParent;
            if (xFound || yFound) return false;
        }
        return false;
    }
}
