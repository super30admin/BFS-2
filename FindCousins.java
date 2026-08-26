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
//Time Complexity: O(n)
//Space Complexity: O(n)
//Approach: while doing BFS using queue, find if x and y are found at the same level, if so make sure they are not siblings.
class FindCousins {
    public boolean isCousins(TreeNode root, int x, int y)
    {

        if (root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean xFound = false;
        boolean yFound = false;

        while (!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0; i<size; i++)
            {
                TreeNode curr = q.poll();
                if(curr.left != null)
                {
                    q.add(curr.left);
                }

                if (curr.right != null)
                {
                    q.add(curr.right);
                }

                if(curr.left != null && curr.right != null)
                {
                    if((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x))
                    {
                        return false;
                    }
                }

                if(curr.val == x)
                {
                    xFound = true;
                }

                if(curr.val == y)
                {
                    yFound = true;
                }
            }

            if (xFound && yFound) return true;
            if (xFound || yFound) return false;
        }

        return false;
    }
}