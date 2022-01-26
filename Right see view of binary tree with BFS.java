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
//Time complexity: O(n)
//Space complexity: O(n/2) or O(2^h-1)
class Solution {
     
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res= new ArrayList();
        if(root==null)
            return res;
       Queue<TreeNode> q= new LinkedList();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size= q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp= q.poll();
                if(i==size-1)
                    res.add(temp.val);
               if(temp.left!=null)
                   q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
        }
        return res;
    }
}