//TC: O(n)
//SC: O(h)
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
    private void helper(TreeNode root,int level,List<Integer> result)
    {
        if(root==null)return;
        if(level==result.size())
        result.add(root.val);
        helper(root.right,level+1,result);
         helper(root.left,level+1,result);
    }
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer> result =new ArrayList<>();
         if(root ==null)return result;
         helper(root,0,result);
        return result;
    }
}