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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return res;
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i =0 ; i< size; i++)
            {
                TreeNode curr = q.remove();
                if(i == size-1)
                {
                    res.add(curr.val);
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
      return res;  
    }
}