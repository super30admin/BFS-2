
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Intuition: We can use BFS/DFS to traverse the tree level by level.

import java.util.*;
import java.util.LinkedList;

public class CousinsInBinaryTree_BFS {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int count = q.size();
            boolean x_is_found = false;
            boolean y_is_found = false;

            for (int i = 0; i < count; i++) {
                TreeNode node = q.poll();
                if (node.val == x)
                    x_is_found = true;
                if (node.val == y)
                    y_is_found = true;
                if (node.left != null && node.right != null) {
                    if (node.left.val == x && node.right.val == y)
                        return false;

                    if (node.left.val == y && node.right.val == x)
                        return false;
                }

                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);

            }

            if (x_is_found && y_is_found)
                return true;
        }

        return false;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Intuition: We can use BFS/DFS to traverse the tree level by level.
class CousinsInBinaryTree_DFS {
    int x_depth = -1;
    int y_depth = -1;
    TreeNode x_parent = null;
    TreeNode y_parent = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        calDepthAndParent(root, x, y, 0, null);
        return x_depth == y_depth && x_parent != y_parent;
    }

    public void calDepthAndParent(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if (root == null)
            return;

        if (root.val == x) {
            x_parent = parent;
            x_depth = depth;
        }

        if (root.val == y) {
            y_parent = parent;
            y_depth = depth;
        }

        calDepthAndParent(root.left, x, y, depth + 1, root);
        calDepthAndParent(root.right, x, y, depth + 1, root);
    }
}
