// Time Complexity : O(n) all nodes
// Space Complexity : O(n) n/2 leaf nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// we are performing dfs and if x and y are found we are storing their level and parent. 
// 2 tree nodes are said to be cousins if they are of same level and have different parents

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
    int xlevel=-1;
    int ylevel=-1;
    TreeNode xparent;
    TreeNode yparent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return true;
        
        dfs(root,x,y,0,null);
        return xlevel == ylevel && xparent != yparent;
        }
        private void dfs(TreeNode root, int x, int y,int level, TreeNode parent){
            if(root==null) return;

            //logic
            if(root.val == x)
            {
                xlevel=level;
                xparent = parent;
            }
             if(root.val == y)
            {
                ylevel=level;
                yparent = parent;
            }
            dfs(root.left,x,y,level+1,root);
            dfs(root.right,x,y,level+1,root);
    }
}