// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        List<Integer> ls = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ls.add(root.val);

        res.add(root.val);
        ls.clear();
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    ls.add(node.left.val);
                    q.add(node.left);
                }
                if (node.right != null) {
                    ls.add(node.right.val);
                    q.add(node.right);
                }
            }

            if (ls.size() > 0) {
                res.add(ls.get(ls.size() - 1));
            }
            ls.clear();
        }

        return res;

    }
}