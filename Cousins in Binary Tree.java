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
    public boolean isCousins(TreeNode root, int x, int y) {

        if(root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();

            ArrayList<Integer> list = new ArrayList<>();

            for(int i=0 ; i<size ; i++)
            {
                TreeNode curr = q.poll();

                list.add(curr.val);

                if(curr.right != null && curr.left != null)
                {
                    if(curr.right.val == x && curr.left.val == y) return false;
                    if(curr.right.val == y && curr.left.val == x) return false;
                }
                if(curr.right != null) q.add(curr.right);
                if(curr.left != null ) q.add(curr.left);
            }

            if(list.contains(x) && list.contains(y)) return true;

        }

        return false;

    }
}
