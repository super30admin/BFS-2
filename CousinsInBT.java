// TC: O(N)
// SC: O(N)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> parentQ = new LinkedList<>();

        q.add(root);
        parentQ.add(null);

        boolean x_found = false, y_found = false;
        TreeNode x_parent = null, y_parent = null;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                TreeNode parent = parentQ.poll();

                // we will check this condition for nodes with both left and right child because only they can have siblings.
                if(curr.left != null && curr.right != null) {
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.right.val == x && curr.left.val == y) return false;
                }

                if(curr.val == x) {
                    x_found = true;;
                }

                if(curr.val ==y) {
                    y_found = true;
                }

                if(curr.left != null) {
                    q.add(curr.left);
                }

                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            if(x_found && y_found) return true;
            if(x_found || y_found) return false;
        }
        return true; // does not matter what we return here
    }
}
