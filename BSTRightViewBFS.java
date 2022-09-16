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
//tc= o(n)
//sc-o(n)
    
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty())
        {
        int size = q.size();
        for(int i=0;i<size;i++)
        {
            TreeNode curr =q.poll();
            //add i=0 if we need left view
            if(i == size-1)
            {
                result.add(curr.val);
            }// if last elemet add it to result
            
            if(curr.left != null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
        }
        }
        return result;
    }
}