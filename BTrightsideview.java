//TC:O(n)
//SC:O(n)
//Sucessfully ran on leetcode
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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> output=new ArrayList<>();

        if(root==null)
            return output;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int size=q.size();
            int temp=-1;

            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();

                temp=node.val;

                if(node.left!=null)
                    q.add(node.left);

                if(node.right!=null)
                    q.add(node.right);

            }

            output.add(temp);
        }

        return output;
    }
}
