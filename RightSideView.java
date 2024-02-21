import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class RightSideView {
    List<Integer> res;

    // Time complexity: O(n)
    // Space complexity: O(h)

    // Approach: Only adding items if this is the first time at a certain level

    public List<Integer> rightSideView(TreeNode root) {
        this.res = new ArrayList();
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int height) {
        if (node == null) {
            return;
        }

        // first time visiting this level
        if (height == res.size()) {
            res.add(node.val);
        }

        dfs(node.right, height + 1);
        dfs(node.left, height + 1);
    }

    // Time complexity: O(n)
    // Space complexity: O(n)

    // Approach: Level order traversal and add the last element to the res;

    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (root == null) {
            return res;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (i == size - 1) {
                    res.add(current.val);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return res;
    }

}