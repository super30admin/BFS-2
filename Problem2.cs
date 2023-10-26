public class CousinsInBT
    {
        // Time Complexity : O(n)
        // Space Complexity : O(h)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        TreeNode parent_x;
        TreeNode parent_y;
        int depth_x;
        int depth_y;

        public bool IsCousins(TreeNode root, int x, int y)
        {
            dfs(root, null, x, y, 0);
            return depth_x == depth_y && parent_x != parent_y;

        }

        public void dfs(TreeNode root, TreeNode parent, int x, int y, int depth)
        {
            //base case
            if (root == null) return;

            //logic
            if(root.val == x)
            {
                parent_x = parent;
                depth_x = depth;
            }
            if(root.val == y)
            {
                parent_y = parent;
                depth_y = depth;
            }

            if(parent_x == null || parent_y == null)
            {
                dfs(root.left, root, x, y, depth + 1);
                dfs(root.right, root, x, y, depth + 1);
            }


        }
    }
