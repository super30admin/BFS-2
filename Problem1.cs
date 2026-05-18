// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree (space consumed by recursion stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
    I perform DFS on the nodes of the tree with one slight change - I visit the right child of each tree before visiting the left child. I maintain a global result list and whenever the level equals
    length of the list, I add the value of the node to the list.
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
public class Solution
{
    private List<int> result;
    public IList<int> RightSideView(TreeNode root)
    {
        result = new();
        Helper(root, 0);
        return result;
    }

    public void Helper(TreeNode root, int level)
    {
        if (root == null)
        {
            return;
        }

        if (result.Count == level)
        {
            result.Add(root.val);
        }

        Helper(root.right, level + 1);
        Helper(root.left, level + 1);
    }
}