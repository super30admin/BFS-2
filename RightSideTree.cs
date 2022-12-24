// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
        var result = new List<int>();
        if(root == null) return result;
        var q = new Queue<TreeNode>();
        q.Enqueue(root);
        while(q.Count > 0)
        {
            var count = q.Count;
            for(int i = 0; i < count; i++)
            {
                var node = q.Dequeue();
                if(i == count -1)
                {
                    result.Add(node.val);   
                }                         
                
                if(node.left != null) q.Enqueue(node.left);
                if(node.right != null) q.Enqueue(node.right);
            }
        }
       
        return result;
    }    
}
