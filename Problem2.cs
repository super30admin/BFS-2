// Time Complexity : O(n)
// Space Complexity : O(h) where h is the space consumed by the recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I perform DFS on the nodes of the tree and maintain global variables which track parents of x and y nodes and levels of x and y. Whenever I come across x or y, I update the values of their levels and
their parents. After performing DFS, I check if their levels are equal and parents differ, if so I return true. Else I return false.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    private int xLevel;
    private int yLevel;
    private TreeNode xParent;
    private TreeNode yParent;
    
    public bool IsCousins(TreeNode root, int x, int y) {
        xLevel = 0;
        yLevel = 0;
        Helper(root, root.left, x, y, 1);
        Helper(root, root.right, x, y, 1);
        return xLevel == yLevel && xParent != yParent;
    }

    public void Helper(TreeNode parent, TreeNode root, int x, int y, int level)
    {
        if(root == null)
        {
            return;
        }

        if(root.val == x)
        {
            xLevel = level;
            xParent = parent;
        }
        
        if(root.val == y)
        {
            yLevel = level;
            yParent = parent;
        }

        Helper(root, root.left, x, y, level + 1);
        Helper(root, root.right, x, y, level + 1);
    }

}