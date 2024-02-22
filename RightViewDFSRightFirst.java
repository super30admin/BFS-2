import java.util.ArrayList;
import java.util.List;

// TC - O(N)
// SC - O(h) => Stack Space

// Constraints:
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

public class RightViewDFSRightFirst {

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
        private List<Integer> rightViewList;

        public List<Integer> rightSideView(TreeNode root) {
            this.rightViewList = new ArrayList<>();

            if (root == null) {
                return rightViewList;
            }

            dfs(root, 0);

            return rightViewList;
        }

        private void dfs(TreeNode root, int level) {
            if (root == null) {
                return;
            }

            if (rightViewList.size() <= level) {
                rightViewList.add(root.val);
            }

            dfs(root.right, level + 1);
            dfs(root.left, level + 1);
        }
    }
}