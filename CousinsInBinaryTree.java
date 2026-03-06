// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The main idea is that if 2 nodes have same parent and do not share same level, then they are not cousins.So,
we iteratively check through a queue if the incoming node's children equal to x and y, then return false as
same parent.Similarly, we update 2 boolean found variables when x and y are found. Since we are doing level
order traversal, if the found variables do not get updated at same level, that means they are not cousins.
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
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean xFound = false, yFound = false;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0 ; i < size ; i++) {
                TreeNode curr = q.poll();
                if(curr.left != null && curr.right != null) {
                    if(curr.left.val == x && curr.right.val == y)
                        return false;
                    if(curr.left.val == y && curr.right.val == x)
                        return false;
                }

                if(curr.val == x)
                    xFound = true;
                if(curr.val == y)
                    yFound = true;
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
            if(xFound && yFound)
                return true;
            if(xFound || yFound)
                return false;
        }
        return false;
    }
}