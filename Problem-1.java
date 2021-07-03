import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity : O(h)    (height of the tree)
// Space Complexity : O(n)   (width of the tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// We perform level order traversal
// At every level we add the last node into result 
// Last node can be accessed with the help of size variable
class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // null check
        if (root == null)
            return result;

        // Level order traversal
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 1; i <= n; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    if (i == n) {
                        result.add(node.val);
                    }
                    if (node.left != null)
                        q.add(node.left);
                    if (node.right != null)
                        q.add(node.right);
                }
            }
        }

        return result;
    }
}