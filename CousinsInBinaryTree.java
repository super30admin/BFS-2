/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int x_level_dfs = 0, y_level_dfs = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        // bfs
        if(null == root) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean x_level = false, y_level = false;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode currNode = queue.poll();
                if(null != currNode.left && null != currNode.right)
                {
                    if(x == currNode.left.val && y == currNode.right.val)
                    {
                        return false;
                    }
                    if(y == currNode.left.val && x == currNode.right.val)
                    {
                        return false;
                    }
                }
                if(null != currNode.left)
                {
                    queue.add(currNode.left);
                    if(x == currNode.left.val)
                    {
                        x_level = true;
                    }
                    if(y == currNode.left.val)
                    {
                        y_level = true;
                    }
                }
                if(null != currNode.right)
                {
                    queue.add(currNode.right);
                    if(x == currNode.right.val)
                    {
                        x_level = true;
                    }
                    if(y == currNode.right.val)
                    {
                        y_level = true;
                    }
                }
            }
            if(x_level)
            {
                return y_level;
            }
            if(y_level)
            {
                return x_level;
            }
        }
        return true;

        // // dfs
        // dfs(root, 0, x, y);
        // // System.out.println(x_level_dfs);
        // // System.out.println(y_level_dfs);
        // if(0 != x_level_dfs && 0!= y_level_dfs)
        // {
        //     return x_level_dfs == y_level_dfs;
        // }
        // return false;
    }

    // private void dfs(TreeNode root, int level, int x, int y)
    // {
    //     // base
    //     if(null == root) return;

    //     // logic
    //     if(null != root.left && null != root.right)
    //     {
    //         if(x == root.left.val && y == root.right.val)
    //         {
    //             return;
    //         }
    //         if(y == root.left.val && x == root.right.val)
    //         {
    //             return;
    //         }
    //     }
    //     if(x == root.val)
    //     {
    //         x_level_dfs = level;
    //     }
    //     if(y == root.val)
    //     {
    //         y_level_dfs = level;
    //     }

    //     dfs(root.left, level+1, x, y);
    //     dfs(root.right, level+1, x, y);
    // }
}