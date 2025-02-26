// time complexity - O(n)
// space complexity - O(n)
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
    public bool IsCousins(TreeNode root, int x, int y)
    {
        Queue<TreeNode> bfs = new Queue<TreeNode>();
        bfs.Enqueue(root);
        while (bfs.Count > 0)
        {
            bool yFound = false;
            bool xFound = false;
            int size = bfs.Count();
            while (size > 0)
            {
                TreeNode node = bfs.Dequeue();
                if (node.val == x)
                {
                    xFound = true;
                }
                if (node.val == y)
                {
                    yFound = true;
                }
                if (node.left != null && node.right != null)
                {
                    if ((node.left.val == x && node.right.val == y) || (node.right.val == x && node.left.val == y))
                    {
                        return false;
                    }
                }
                if (node.left != null)
                {
                    bfs.Enqueue(node.left);
                }
                if (node.right != null)
                {
                    bfs.Enqueue(node.right);
                }
                size--;
            }
            if (yFound && xFound)
            {
                return true;
            }
        }
        return false;
    }
}