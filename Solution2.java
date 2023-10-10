// Leetcode Problem : https://leetcode.com/problems/cousins-in-binary-tree/
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I initialize x_found and y_found to false. I add root to the Queue and perform BFS while queue is not empty. Temp = q.poll(). If temp.val == x, I set x_found=true. If temp.val==y, I set y_found=true. If temp.left and temp.right !=null and either of the values equal to x and y respectively
 * I return false. At the end I add temp.left and temp.right to the queue if they exist. If either x_found or y_found is true, I return x_found and y_found. 
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
        boolean x_found = false;
        boolean y_found = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp = q.poll();
                if(temp.val==x)
                {
                    x_found=true;
                }
                if(temp.val==y)
                {
                    y_found=true;
                }
                if(temp.left!=null && temp.right!=null)
                {
                    if(temp.left.val==x && temp.right.val==y)
                    {
                        return false;
                    }
                    if(temp.left.val==y && temp.right.val==x)
                    {
                        return false;
                    }
                }
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
            }
             if(x_found || y_found)
                {
                    return x_found && y_found;
                }
        }
        return true;

    }
}