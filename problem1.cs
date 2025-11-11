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
        if(root == null) return [];
        IList<int> result = new List<int>();
        Queue<TreeNode> q= new Queue<TreeNode>();
        q.Enqueue(root);
        while(q.Count>0)
        {
            int size = q.Count;
            for(var i=0;i<size;i++)
            {
                TreeNode node = q.Dequeue();
                if(i+1==size)
                {
                    result.Add(node.val);
                }
                if(node.left!=null)
                {
                    q.Enqueue(node.left);
                }
                if(node.right!=null)
                {
                    q.Enqueue(node.right);
                }
                
            }

        }
        return result;
        
    }
}