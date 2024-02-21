import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// TC - O(N)
// SC - O(N) => N/2 at last level of BFS

// Constraints:
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

public class RightViewBFS {

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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> rightViewList = new ArrayList<>();

            if (root == null) {
                return rightViewList;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode currNode = queue.poll();
                    if (size == 1) {
                        rightViewList.add(currNode.val);
                    }
                    if (currNode.left != null) {
                        queue.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        queue.add(currNode.right);
                    }
                    size--;
                }
            }

            return rightViewList;
        }
    }
}