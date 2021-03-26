import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity : O(n); n = #nodes
// Space Complexity : O(n) for BFS; O(height of tree) for DFS
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class RightSideView {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
        //BFS
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<>();

            if (root == null) return list;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                    if (i == size - 1)
                        list.add(node.val);
                }
            }
            return list;
        }
        //DFS
        List<Integer> list = new ArrayList<>();
        public List<Integer> rightSideViewDFS(TreeNode root) {
            if (root == null) return list;
            dfs(root, 0);
            return list;
        }
        private void dfs(TreeNode root, int level) {
            if (root == null)
                return;

            if (list.size() == level)
                list.add(root.val);

            dfs(root.right, level + 1);
            dfs(root.left, level + 1);
        }
}
