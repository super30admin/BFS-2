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

//Space Complexity=O(n)
//Time complexity=O(n)
//We are using DFS in this method to solve our problem
class Solution {
    TreeNode xparent,yparent;
    int x_level,y_level;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        dfs(root,0,null,x,y);
        if(x_level==y_level && xparent!=yparent) return true;
        return false;
        
    }
    private void dfs(TreeNode curr, int level,TreeNode parent,int x,int y)
    {
        if(curr==null) return;
        
        if(curr.val==x)
        {
            xparent=parent;
            x_level=level;
        }
        if(curr.val==y)
        {
            yparent=parent;
            y_level=level;
        }
        dfs(curr.left,level+1,curr,x,y);
        dfs(curr.right,level+1,curr,x,y);
    }
}