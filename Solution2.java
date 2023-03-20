// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I maintain two boolean values x_found and y_found which indicate if x or y values have been found in a level. Initially both are set to 
 * false. I add root to the queue and perform bfs while !q.isEmpty(). If the value of element popped from q is x or y, I set the corresponding
 * x_found or y_found to true. If current.left.val ==x and current.right.val==y or vice versa, I return false since the two values are then 
 * siblings and not cousins. I then add current.left and current.right to the queue either value is not null.
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
        boolean x_found = false, y_found = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode current = q.poll();
                if(current.val == x)
                {
                    x_found=true;
                }
                if(current.val==y)
                {
                    y_found=true;
                }
                if(current.left!=null && current.right!=null)
                {
                    if(current.left.val==x && current.right.val==y)
                    {
                        return false;
                    }
                    if(current.left.val==y && current.right.val==x)
                    {
                        return false;
                    }
                }
                if(current.left!=null)
                {
                    q.add(current.left);
                }
                if(current.right!=null)
                {
                    q.add(current.right);
                }
            }
            if(x_found==true || y_found==true)
                {
                    return x_found && y_found;
                }
        }
        return true;
    }
}