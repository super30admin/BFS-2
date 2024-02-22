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

public class TreeCousinsBFSWithSingleQueue {

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

            childQueue.add(root);

            while (!childQueue.isEmpty()) {
                int size = childQueue.size();
                boolean foundX = false;
                boolean foundY = false;

                while (size > 0) {
                    TreeNode childNode = childQueue.poll();

                    if (childNode.left != null && childNode.right != null) {
                        if (childNode.left.val == x && childNode.right.val == y) {
                            return false;
                        }
                        if (childNode.left.val == y && childNode.right.val == x) {
                            return false;
                        }
                    }

                    if (childNode.left != null) {
                        if (childNode.left.val == x) {
                            foundX = true;
                        } else if (childNode.left.val == y) {
                            foundY = true;
                        }
                        childQueue.add(childNode.left);
                    }

                    if (childNode.right != null) {
                        if (childNode.right.val == x) {
                            foundX = true;
                        } else if (childNode.right.val == y) {
                            foundY = true;
                        }
                        childQueue.add(childNode.right);
                    }

                    if (foundX && foundY) {
                        return true;
                    }
                    size--;
                }

            }
            return false;
        }
    }
}
