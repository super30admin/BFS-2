import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(n) [n: number of nodes]
// Space Complexity : O(w) [w: width of tree]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// We can perform Level order traversal
// This automatically ensures that we check nodes on the same level
// Only check we need to perform is - given 2 node's parents are same or not 
// we can do this by maintianing flag xFound/yFound in that level
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;

        boolean xFound = false, yFound = false;

        // level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.val == x)
                    xFound = true;
                else if (node.val == y)
                    yFound = true;

                if (node.left != null && node.right != null) {
                    if (node.left.val == x && node.right.val == y)
                        return false;
                    if (node.left.val == y && node.right.val == x)
                        return false;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (xFound && yFound)
                return true; // both x and y are found in this level
            if (xFound || yFound)
                return false; // only one of x and y is found
        }

        return false;
    }
}