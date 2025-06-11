/*
  Time complexity: O(n)
  Space complexity:O(n)

  Code ran successfully on Leetcode: Yes

*/

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
public class Solution {
    public bool IsCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new();
        HashSet<int> hs = new();
        hs.Add(x);
        hs.Add(y);

        queue.Enqueue(root);

        while(queue.Count>0)
        {
            bool cousins = false;
            HashSet<int> hs2 = new();
            int size = queue.Count;
            
            for(int i=0;i<size;i++)
            {
                TreeNode temp = queue.Dequeue();
                
                hs2.Add(temp.val);

                if(temp.left!=null)
                {
                    queue.Enqueue(temp.left);
                }
                if(temp.right!=null) 
                {
                    queue.Enqueue(temp.right);
                }
                if(temp.left!=null && temp.right!=null)
                {
                    if(hs.Contains(temp.left.val) && hs.Contains(temp.right.val))
                        return false;
                }
            }
            if(hs2.Contains(x) && hs2.Contains(y))
                return true;
        }
        return false;
    }
}
