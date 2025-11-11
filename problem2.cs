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
        if(root == null) return false;
        Queue<TreeNode> q = new Queue<TreeNode>();
        Queue<TreeNode> parentQ = new Queue<TreeNode>();
        q.Enqueue(root);
        parentQ.Enqueue(null);
        var isCousins = false;
        while(q.Count>0)
        {
            var count = 0;
            var qCount = q.Count;
            var xFound=false;
            var yFound=false;
            TreeNode xParent = null;
            TreeNode yParent = null;
            while(count<qCount){
            var node = q.Dequeue();
            var parentNode = parentQ.Dequeue();
            if(node.val==x)
            {
                xFound = true;
                xParent = parentNode;
            }
            if(node.val==y)
            {
                yFound = true;
                yParent = parentNode;
            }
            if(node.left!=null)
            {
                q.Enqueue(node.left);
                parentQ.Enqueue(node);
            }
            if(node.right!=null)
            {
                q.Enqueue(node.right);
                parentQ.Enqueue(node);
            }
            count++;
            }
            if(xFound&&yFound&&xParent!=yParent)
            { 
                 isCousins = true;
                 break;
            }
        }
        return isCousins;
    }
}