using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class BinaryTreeRightSideView
    {
        /// Time Complexity : O(N) 
        // Space Complexity :O(N) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No 
        public IList<int> RightSideView_BFS(TreeNode root)
        {
            List<int> result = new List<int>();
            if (root == null) return result;
            Queue<TreeNode> q = new Queue<TreeNode>();
            q.Enqueue(root);
            while (q.Count != 0)
            {
                int size = q.Count;
                for (int i = 0; i < size; i++)
                {
                    TreeNode curr = q.Dequeue();
                    if (i == (size - 1))
                    {
                        result.Add(curr.val);
                    }
                    if (curr.left != null) q.Enqueue(curr.left);
                    if (curr.right != null) q.Enqueue(curr.right);
                }
            }
            return result;
        }

        public IList<int> LeftSideView_BFS(TreeNode root)
        {
            List<int> result = new List<int>();
            if (root == null) return result;
            Queue<TreeNode> q = new Queue<TreeNode>();
            q.Enqueue(root);
            while (q.Count != 0)
            {
                int size = q.Count;
                for (int i = 0; i < size; i++)
                {
                    TreeNode curr = q.Dequeue();
                    if (i == 0)
                    {
                        result.Add(curr.val);
                    }
                    if (curr.left != null) q.Enqueue(curr.left);
                    if (curr.right != null) q.Enqueue(curr.right);
                }
            }
            return result;
        }


        List<int> result = new List<int>();
        public IList<int> RightSideView_DFS(TreeNode root)
        {
            if (root == null) return result;
            dfs(root, 0);
            return result;
        }

        private void dfs(TreeNode root, int level)
        {
            //base
            if (root == null) return;
            //logic
            if (level == result.Count)
            {
                result.Add(root.val);
            }
            dfs(root.right, level + 1);
            dfs(root.left, level + 1);
        }
    }
}
