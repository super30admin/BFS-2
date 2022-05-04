using System;
using System.Collections.Generic;
using System.Text;

namespace BinaryTree
{
    public class CousinsTree
    {
        /* T.C: O(n) since we are traversing all the node of the tree
         * S.C: O(h) where h is hight of the tree
        */
        //DFS
        int x_lvl, y_lvl;
        TreeNode x_prt, y_prt;
        public bool IsCousins(TreeNode root, int x, int y)
        {

            dfs(root, 0, null, x, y);

            if (x_lvl == y_lvl && x_prt != y_prt)
                return true;

            return false;

        }

        private void dfs(TreeNode root, int lvl, TreeNode parent, int x, int y)
        {
            //base
            if (root == null)
                return;

            //logic
            if (root.val == x)
            {
                x_lvl = lvl;
                x_prt = parent;
            }

            if (root.val == y)
            {
                y_lvl = lvl;
                y_prt = parent;
            }

            if (x_prt == null || y_prt == null)
            {
                dfs(root.left, lvl + 1, root, x, y);
                dfs(root.right, lvl + 1, root, x, y);
            }
        }

        //BFS approch
        /*
         * T.C: O(n) : since we are traversing all element
         * S.C: O(n) 
         */
        public bool IsCousinsBFS(TreeNode root, int x, int y)
        {
            Queue<TreeNode> queue = new Queue<TreeNode>();
            queue.Enqueue(root);

            while (queue.Count != 0)
            {
                int size = queue.Count;
                bool xfound = false;
                bool yfound = false;
                for (int i = 0; i < size; i++)
                {
                    TreeNode curr = queue.Dequeue();

                    if (curr.val == x)
                    {
                        xfound = true;
                    }
                    if (curr.val == y)
                    {
                        yfound = true;
                    }

                    if (curr.left != null && curr.right != null)
                    {
                        if (curr.left.val == x && curr.right.val == y)
                            return false;

                        if (curr.right.val == x && curr.left.val == y)
                            return false;
                    }

                    if (curr.left != null)
                    {
                        queue.Enqueue(curr.left);
                    }
                    if (curr.right != null)
                    {
                        queue.Enqueue(curr.right);
                    }
                }

                if (xfound && yfound)
                    return true;

                if (xfound || yfound)
                    return false;
            }

            return false;
        }
    }
}
