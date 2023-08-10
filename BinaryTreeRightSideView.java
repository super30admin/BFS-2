// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(w) where w is the maximum width of the binary tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Integer lastNodeValue = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                lastNodeValue = node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(lastNodeValue);
        }

        return result;
    }
}