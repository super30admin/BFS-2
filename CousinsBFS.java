// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package bfs2;

import java.util.*;

public class CousinsBFS {

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean foundX = false, foundY = false;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.val == x) {
                    foundX = true;
                }
                if (curr.val == y) {
                    foundY = true;
                }
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y) {
                        return false;
                    }
                    if (curr.left.val == y && curr.right.val == x) {
                        return false;
                    }
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            if (foundX && foundY) {
                return true;
            }
            if (foundX || foundY) {
                return false;
            }
        }
        return false;
    }
}
