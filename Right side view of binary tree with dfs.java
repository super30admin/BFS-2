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
//Time complexity: O(n)
//Space complexity: O(h)
class Solution {
     List<Integer> res= new ArrayList();
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root==null)
            return res;
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode root, int level)
    {
        if(root==null)
            return;
        //System.out.println(level+" "+res.size());
        if(level==res.size())
        {
            res.add(root.val);
        }
        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}