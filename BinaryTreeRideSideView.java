/**
 * Time Complexity (TC): O(n) - n: no.of nodes in the binary tree
 * Space Complexity (SC): O(n)
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode deletedNode = queue.poll();

                if (i == size - 1)
                    result.add(deletedNode.val);

                if (deletedNode.left != null)
                    queue.add(deletedNode.left);

                if (deletedNode.right != null)
                    queue.add(deletedNode.right);
            }
        }

        return result;
    }
}
