using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class BinaryTreeCousins
    {
        /// Time Complexity : O(N) 
        // Space Complexity :O(N) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No
        public bool IsCousins(TreeNode root, int x, int y)
        {
            Queue<TreeNode> q = new Queue<TreeNode>();
            Queue<TreeNode> qP = new Queue<TreeNode>();
            q.Enqueue(root);
            qP.Enqueue(null);
            while (q.Count != 0)
            {
                int size = q.Count;
                bool x_found = false; TreeNode x_Parent = null;
                bool y_found = false; TreeNode y_Parent = null;
                for (int i = 0; i < size; i++)
                {
                    TreeNode curr = q.Dequeue();
                    TreeNode currP = qP.Dequeue();
                    if (x == curr.val)
                    {
                        x_found = true;
                        x_Parent = currP;
                    }
                    if (y == curr.val)
                    {
                        y_found = true;
                        y_Parent = currP;
                    }
                    if (curr.left != null)
                    {
                        q.Enqueue(curr.left);
                        qP.Enqueue(curr);
                    }

                    if (curr.right != null)
                    {
                        q.Enqueue(curr.right);
                        qP.Enqueue(curr);
                    }


                }
                if (x_found && y_found) return x_Parent != y_Parent;
                if (x_found || y_found) return false;
            }
            return false;

        }
    }
}
