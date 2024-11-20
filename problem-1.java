// Time Complexity :
//      n - number of nodes
//      total time complexity will be O(n)
//
// Space Complexity :
//      O(n)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        int s = 0, count = 0;
        if(root == null)
            return false;
        q.offer(root);
        while(!q.isEmpty())
        {
            s = q.size();
            for(int i=0; i<s;i++)
            {
                TreeNode temp = q.poll();
                if(temp.left!=null)
                {
                    q.offer(temp.left);
                }
                if(temp.right!=null)
                {
                    q.offer(temp.right);
                }
                if(temp.left!=null && temp.right!=null)
                {
                    if((temp.left.val==x && temp.right.val==y) || (temp.left.val==y && temp.right.val==x))
                    {
                        return false;
                    }
                }
                if(temp.val == x)
                {
                    count++;
                }
                if(temp.val == y)
                {
                    count++;
                }
            }
            if(count == 2)
            {
                return true;
            }
            count = 0;
        }
        return false;
    }
}