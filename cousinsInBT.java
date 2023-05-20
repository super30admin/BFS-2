// Time Complexity : O(n)
// Space Complexity : O(h) (height of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * We use BFS here to check for nodes at each level. When we traverse each level
 * we first check whether the current node has both the children with both the
 * given values. If they do, then we say that they're not cousins. Otherwise, we
 * track whether the given values are present in the current level. If they
 * both are present, then we say they're cousins (as the sibling check was
 * already done).
 */

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

import java.util.*;
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            boolean xfound = false, yfound = false;
            for(int i=0; i<size; i++) {
                TreeNode c = q.poll();
                if(c.left != null && c.right != null && 
                 (c.left.val == x || c.left.val == y) && 
                 (c.right.val == x || c.right.val == y))
                    return false; // same parent
                if(c.val == x)
                    xfound = true;
                if(c.val == y)
                    yfound = true;
                if(c.left != null)
                    q.add(c.left);
                if(c.right != null)
                    q.add(c.right);
            }
            // finally check whether they were found
            if(xfound && yfound) // both found in this level
                return true;
            if(xfound || yfound) // only one found in this level
                return false;
        }

        return false;
    }
}