// Time Complexity : o(n)
// Space Complexity :o(n) where n is the diameter of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
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
        boolean xval = false, yval = false;
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return false;
        q.add(root);
        while(!q.isEmpty())
        {
            xval = false; yval = false;
            int size = q.size();
            for(int i=0; i< size; i++)
            {
                TreeNode node = q.poll();
                if(node.val == x) xval = true;
                if(node.val == y) yval = true;
                if(node.left != null && node.right != null && node.left.val == x && node.right.val == y) return false;
                if(node.left != null && node.right != null && node.left.val == y && node.right.val == x) return false;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if (xval && yval) return true;
        }
        return false;
    }
}