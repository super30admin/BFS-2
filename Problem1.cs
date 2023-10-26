public class BTRightSideView
    {
        // Time Complexity : O(n)
        // Space Complexity : O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public IList<int> RightSideView(TreeNode root)
        {
            List<int> result = new List<int>();
            //edge case
            if (root == null) return result;

            Queue<TreeNode> q = new Queue<TreeNode>();
            q.Enqueue(root);

            while (q.Count > 0)
            {
                int size = q.Count;
                for (int i = 0; i < size; i++)
                {
                    TreeNode curr = q.Dequeue();
                    if (i == size - 1)
                    {
                        result.Add(curr.val);
                    }
                    if (curr.left != null)
                    {
                        q.Enqueue(curr.left);
                    }
                    if (curr.right != null)
                    {
                        q.Enqueue(curr.right);
                    }
                }
            }
            return result;
        }
    }
