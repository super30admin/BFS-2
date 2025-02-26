// time complexity -O(n)
// space compelxity - O(n)
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
    public IList<int> RightSideView(TreeNode root)
    {
        IList<int> res = new List<int>();
        if (root == null)
        {
            return res;
        }
        // DFS
        helper(root, res, 0);
        return res;
        //BFS
        // Queue<TreeNode> bfs = new Queue<TreeNode>();
        // bfs.Enqueue(root);        
        // while(bfs.Count() > 0)
        // {
        //     int size = bfs.Count();
        //     for(int i=0;i<size;i++)
        //     {
        //         TreeNode node = bfs.Dequeue();
        //         if(i==0)
        //         {
        //             res.Add(node.val);
        //         }
        //         if(node.right !=null)
        //         {
        //             bfs.Enqueue(node.right);
        //         }
        //         if(node.left !=null)
        //         {
        //             bfs.Enqueue(node.left);
        //         }
        //     }           
        // }
        // return res;
    }

    private void helper(TreeNode root, IList<int> res, int level)
    {
        // base
        if (root == null)
        {
            return;
        }
        //logic
        if (res.Count() == level)
        {
            res.Add(root.val);
        }
        helper(root.right, res, level + 1);
        helper(root.left, res, level + 1);
    }
}