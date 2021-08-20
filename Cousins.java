//https://leetcode.com/problems/cousins-in-binary-tree/
/*
Time: O(n) where n = number of tree nodes
Space: O(n) for the Queue
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class Cousins {

    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null)
            return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean xfound = false; // extra flag from Level Order Problem
            boolean yfound = false; // extra flag from Level Order Problem
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                // extra block to check if nodes exist
                if (cur.val == x)
                    xfound = true;
                if (cur.val == y)
                    yfound = true;

                // extra block for Parent check
                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == x && cur.right.val == y || cur.left.val == y && cur.right.val == x) // siblings
                        return false;

                }

                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);

            }

            if (xfound && yfound)
                return true;
            if (xfound || yfound)
                return false;

        }
        return false;
    }

}
