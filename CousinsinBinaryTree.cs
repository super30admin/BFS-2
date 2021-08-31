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
 //Time Complexity: O(n)
 //Space Complexity: O(n)
public class Solution {
    public bool IsCousins(TreeNode root, int x, int y) {
          if (root == null) return false;
            Queue<TreeNode> q = new Queue<TreeNode>();
            q.Enqueue(root);
            while (q.Count != 0)
            {
                bool x_found = false;
                bool y_found = false;
                int size = q.Count;
                for (int i = 0; i < size; i++)
                {
                    TreeNode curr = q.Dequeue();
                    if (curr.val == x)
                    {
                        x_found = true;
                    }
                    if (curr.val == y)
                    {
                        y_found = true;
                    }
                    if (curr.left != null && curr.right != null)
                    {
                        if (curr.left.val == x && curr.right.val == y)
                        {
                            return false;
                        }
                        if (curr.left.val == y && curr.right.val == x)
                        {
                            return false;
                        }
                    }
                    if (curr.left != null) q.Enqueue(curr.left);
                    if (curr.right != null) q.Enqueue(curr.right);
                }
                if (x_found && y_found) return true;
                if (x_found || y_found) return false;
            }
            return false;
    }
}