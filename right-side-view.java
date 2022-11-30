
//TC is O(n)
//SC is (n) since the largest width can be n/2
import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (i == size - 1) {
                    // this is the last value
                    result.add(node.val);
                }

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return result;
    }
}