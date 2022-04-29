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
//TC : O(N) SC : O(N)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root== null) return new ArrayList();


        List<Integer> returnList = new ArrayList<> ();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode t = q.poll();
                if(i==size-1)
                    returnList.add(t.val);


                if(t.left!=null)
                    q.add(t.left);

                if(t.right!=null)
                    q.add(t.right);
            }
        }

        return returnList;
    }
}