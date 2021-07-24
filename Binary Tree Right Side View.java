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

        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();

            ArrayList<Integer> list = new ArrayList<>();

            for(int i=0 ; i<size ; i++)
            {
                TreeNode curr = q.poll();

                if(list.size()==0) list.add(curr.val);

                if(curr.right != null) q.add(curr.right);
                if(curr.left != null ) q.add(curr.left);
            }

            res.add(list.get(0));
        }

        return res;

    }
}
