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
    List<Integer> result ;
    public List<Integer> rightSideView(TreeNode root) {
        result  = new ArrayList<>();
        if(root==null)
        {

            return result;
        }
        dfs(root,0);
        return result;

    }
    public void dfs(TreeNode root,int height)
    {
        if(root==null)
        {
            return;
        }
        else
        {
            if(height==result.size())
            {
                result.add(root.val);
            }
        }
        dfs(root.right,height+1);
        dfs(root.left,height+1);
    }
}