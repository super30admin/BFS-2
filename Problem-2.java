// Time Complexity :O(N)
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no 

// Your code here along with comments explaining your approach
/*
We perform a level-order traversal (BFS) to process nodes depth by depth.
At each level, we check whether both x and y are present and ensure they are not siblings (same parent).
If both are found at the same level and are not siblings, they are cousins; otherwise, they are not.
*/


import java.util.*;

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.val == x) foundX = true;
                if (node.val == y) foundY = true;

                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) ||
                        (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (foundX && foundY) return true;
            if (foundX || foundY) return false;
        }

        return false;
    }
}
