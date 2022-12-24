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
    public bool IsCousins(TreeNode root, int x, int y) {        
        var q = new Queue<TreeNode>();
        var pq = new Queue<TreeNode>();
        q.Enqueue(root);
        pq.Enqueue(null);
        while(q.Count > 0)
        {
            var count = q.Count;
            bool x_level = false; TreeNode x_parent = null;
            bool y_level = false; TreeNode y_parent = null;
            for(int i = 0; i< count; i++)
            {               
                var node = q.Dequeue();
                var pNode = pq.Dequeue();
                if(node.val == x)
                {
                    x_parent = pNode;
                    x_level = true;
                }
                if(node.val == y)
                {
                    y_parent = pNode;
                    y_level = true;
                }
                if(node.left != null)
                {
                    q.Enqueue(node.left);
                    pq.Enqueue(node);
                }
                if(node.right != null)
                {
                    q.Enqueue(node.right);
                    pq.Enqueue(node);
                }
            }
            
            if( x_level && y_level)
                return x_parent != y_parent;
            
            if(x_level || y_level)
                return false;
        }  
        return false;     
    }   
}
