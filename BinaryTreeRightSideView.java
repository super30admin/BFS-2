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
//Time O(n)
// Space O(n)

class Solution {
    List<Integer>res;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        dfs(root,0);
        return res;
    }
    public void dfs(TreeNode root, int level)
    {
        if(root==null) return;
        if(res.size()==level)
            res.add(root.val);
        else
        {
            res.set(level, root.val);
        }
        dfs(root.left, level+1);
        dfs(root.right,level+1);
        
    }
}