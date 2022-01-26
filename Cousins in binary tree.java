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
    TreeNode xparent;
    TreeNode yparent;
    int xh; int yh;
    int a, b;

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null || (root.left==null && root.right==null))
            return false;
        a=x;
        b=y;
        dfs(root, null, 0);
        if(xparent!=yparent && xh==yh)
            return true;
        else
            return false;
        
    }
    public void dfs(TreeNode root, TreeNode parent, int height)
    {
        if(root==null)
            return;
        dfs(root.left, root, height+1);
        dfs(root.right, root, height+1);
        if(a==root.val)
        {
            xparent= parent;
            xh=height;
        }
        if(b==root.val)
        {
            yparent= parent;
            yh=height;
        }
    }
}