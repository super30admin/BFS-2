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
    public IList<int> RightSideView(TreeNode root) {
        List<int> result = new List<int>();
        Queue<TreeNode> queue  = new Queue<TreeNode>();
 
        if(root==null) return result;

        queue.Enqueue(root);
        
        while(queue.Count>0)
        {
            int size = queue.Count;

            for(int i=0; i<size; i++)
            {
                TreeNode temp = queue.Dequeue();
                if(temp.left!=null) queue.Enqueue(temp.left);
                if(temp.right!=null) queue.Enqueue(temp.right);

                if(i==size-1)
                    result.Add(temp.val);
            }
        }

        return result;

    }
}
