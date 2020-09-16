// Time Complexity : O(V+ E)
// Space Complexity : O(V+ E)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// 	Not a intuitive solution

// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
      Queue<tuple> queue = new LinkedList<>();

        queue.add(new tuple(null, root, 0));

        tuple X = new tuple(null, null, 0);
        tuple Y = new tuple(null, null, 0);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                tuple current = queue.poll();

                if (current.child.val == x)
                    X = new tuple(current.parent, current.child, current.level);
                else if (current.child.val == y)
                    Y = new tuple(current.parent, current.child, current.level);

                if (current.child.left != null)
                    queue.add(new tuple(current.child, current.child.left, current.level + 1));

                if (current.child.right != null)
                    queue.add(new tuple(current.child, current.child.right, current.level + 1));
            }

            if (X.level == Y.level && X.parent != Y.parent)
                return true;

        }

        return false;
    }

    public class tuple {
        TreeNode parent;
        TreeNode child;
        int level;

        public tuple(TreeNode parent, TreeNode child, int level) {
            this.parent = parent;
            this.child = child;
            this.level = level;
        }

    }

}