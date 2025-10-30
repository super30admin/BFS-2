import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leet Code : https://leetcode.com/problems/binary-tree-right-side-view/description/
 * Approach:
 *
 * 1. BFS (Breadth-First Search) Level Order Traversal:
 *    - Traverse the tree level by level using a queue.
 *    - At each level, add the last node's value to the result (rightmost node at that level).
 *    - Time Complexity: O(N), Space Complexity: O(N)
 *
 * 2. DFS (Depth-First Search) Right-First Traversal:
 *    - Traverse the tree using DFS, visiting the right child before the left.
 *    - Add the first node encountered at each depth to the result (rightmost node at that level).
 *    - Time Complexity: O(N), Space Complexity: O(H) where H is the height of the tree.
 *
 * 3. DFS (Depth-First Search) Left-First with Overwrite:
 *    - Traverse the tree using DFS, visiting the left child before the right.
 *    - Overwrite the value at each depth so the rightmost node remains in the result.
 *    - Time Complexity: O(N), Space Complexity: O(H)
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;

    }

    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, 0, result);
        return result;

    }

    private void dfs(TreeNode node, int depth, List<Integer> result) {
        //base
        if (node == null) return;

        //logic
        if (result.size() == depth) {
            result.add(node.val);
        }
        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        dfs2(root, 0, result);
        return result;

    }

    private void dfs2(TreeNode node, int depth, List<Integer> result) {
        //base
        if (node == null) return;

        //logic
        if (result.size() == depth) {
            result.add(node.val);
        }else {
            result.set(depth, node.val);
        }
        dfs2(node.left, depth + 1, result);
        dfs2(node.right, depth + 1, result);
    }
}
