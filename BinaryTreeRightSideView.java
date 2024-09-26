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
//Time Complexity-O(n)
//Space Complexity-O(n)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>output=new ArrayList();
        if(root==null)
        {
            return output;
        }
        Queue<TreeNode>queue=new LinkedList();
        queue.add(root);
        int size=1;
        while(!queue.isEmpty())
        {
            size=queue.size();
            int temp=-1;
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                if(node.left!=null)
                {
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
                temp=node.val;
            }
            output.add(temp);
        }
        return output;
    }
}