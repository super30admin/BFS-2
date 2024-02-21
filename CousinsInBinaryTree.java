
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class CousinsInBinaryTree {
    TreeNode xParent;
    TreeNode yParent;
    int xHeight;
    int yHeight;

    // Time complexity: O(n)
    // Space complexity: O(n)

    // Approach: BFS and if they are from the same parent return false
    // else if both are found at one level return true
    public boolean isCousinsBFS(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList();
        // atleast two elements in the tree
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            // process elements at current level
            boolean foundX = false;
            boolean foundY = false;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.val == x) {
                    foundX = true;
                }

                if (current.val == y) {
                    foundY = true;
                }

                if (current.left != null && current.right != null) {
                    // both x and y from the same parent
                    if ((current.left.val == x) && (current.right.val == y)
                            || (current.right.val == x) && (current.left.val == y)) {
                        return false;
                    }
                }

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            // current level traversed
            // both found and not from the same parent
            if (foundX && foundY) {
                return true;
            }
            // one found
            if (foundX || foundY) {
                return false;
            }
        }
        return false;
    }

    // Time complexity: O(n)
    // Space complexity: O(h)

    // Approach: Find both items and check if their parents are different and
    // heights are equal
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, x, y, 0);
        if (xHeight == yHeight && xParent != yParent) {
            return true;
        }
        return false;
    }

    public void dfs(TreeNode node, TreeNode parent, int x, int y, int height) {
        if (node == null || (xHeight != 0 && yHeight != 0)) {
            return;
        }

        if (node.val == x) {
            xHeight = height;
            xParent = parent;
        }

        if (node.val == y) {
            yHeight = height;
            yParent = parent;
        }

        dfs(node.left, node, x, y, height + 1);
        dfs(node.right, node, x, y, height + 1);
    }
}