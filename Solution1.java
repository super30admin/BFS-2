// Leetcode Problem : https://leetcode.com/problems/binary-tree-right-side-view/description/
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * If root is null I return ans. I add root to queue. I iterate while q is not empty- I set size to size of queue and flag = false. For i = 0 to size-1, I poll value from queue and add it's val to ans if flag != true and set flag to true. I then add the node's right val to q and then node's left val
 * 
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)
        {
            return ans;
        }
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            boolean flag = false;
            for(int i=0;i<size;i++)
            {
                TreeNode temp = q.poll();
                if(!flag)
                {
                    ans.add(temp.val);
                }
                flag=true;
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
            }
        }
        return ans;
    }
}