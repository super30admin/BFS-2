import java.util.LinkedList;
import java.util.Queue;

// TC - O(N)
// SC - O(N)

// Constraints:
// The number of nodes in the tree is in the range [2, 100].
// 1 <= Node.val <= 100
// Each node has a unique value.
// x != y
// x and y are exist in the tree.

public class TreeCousinsBFSWithParentQueue {

    public class TreeNode {
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

    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            Queue<TreeNode> childQueue = new LinkedList<>();
            Queue<TreeNode> parentQueue = new LinkedList<>();

            childQueue.add(root);
            parentQueue.add(null);

            while (!childQueue.isEmpty()) {
                int size = childQueue.size();
                TreeNode x_parent = null;
                TreeNode y_parent = null;

                while (size > 0) {
                    TreeNode childNode = childQueue.poll();
                    TreeNode parentNode = parentQueue.poll();

                    if (childNode.val == x) {
                        x_parent = parentNode;
                    }

                    if (childNode.val == y) {
                        y_parent = parentNode;
                    }

                    if (childNode.left != null) {
                        childQueue.add(childNode.left);
                        parentQueue.add(childNode); // curr node is parent for curr.left
                    }

                    if (childNode.right != null) {
                        childQueue.add(childNode.right);
                        parentQueue.add(childNode); // curr node is parent for curr.right
                    }

                    size--;
                }

                if (x_parent != null && y_parent != null && x_parent != y_parent) {
                    return true;
                }

            }
            return false;
        }
    }
}
