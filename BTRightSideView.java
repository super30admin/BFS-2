// Time Complexity : O(n)
// Space Complexity : O(h) (height of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * We use BFS here to traverse each level and return the last node in each
 * level.
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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int s = q.size();

            for(int i=0; i<s; i++) {
                TreeNode c = q.poll();
                if(c.left != null)
                    q.add(c.left);
                if(c.right != null)
                    q.add(c.right);
                if(i == s-1)
                    res.add(c.val);
            }
        }

        return res;
    }
}