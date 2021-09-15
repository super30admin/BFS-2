// Time Complexity : O(n) no of nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : took almost one hour to get to the solution


// Your code here along with comments explaining your approach
1. Using BFS add nodes of each level in q and keep popping from the q until last node in q 
insert last node of into result
2. do same for each level


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
    // 
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        if(root == null)
        return rightSide;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ; i < size; i++)
            {
                 TreeNode curr = q.poll();
                 if(i == size-1)
                    {
                        rightSide.add(curr.val);
                    }
                    if(curr.left != null) q.add(curr.left);
                    if(curr.right != null) q.add(curr.right);
               
            }
        }
        
        return rightSide;
    }
}