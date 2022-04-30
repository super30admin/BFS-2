using System;
using System.Collections.Generic;
using System.Text;

namespace BinaryTree
{
    public class RightSideView
    {
        /**
         * T.C: O(N) traversing through all the nodes
         * S.C: O(h) stach will have max of hight of the tree element
         */
        List<int> result;
        public IList<int> GetRightSideView(TreeNode root)
        {
            result = new List<int>();
            if (root == null)
                return result;

            dfs(root, 0);

            return result;
        }

        private void dfs(TreeNode root, int level)
        {
            if (root == null)
                return;

            if (result.Count == level)
                result.Add(root.val);
            else
            {
                result[level] = root.val;
            }

            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
        }
    }
}
