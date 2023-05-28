// Time Complexity : O(n)
// Space Complexity : O(h) (height of tree)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            boolean xfound = false, yfound = false;
            for(int i=0; i<size; i++) {
                TreeNode c = q.poll();
                if(c.left != null && c.right != null && 
                 (c.left.val == x || c.left.val == y) && 
                 (c.right.val == x || c.right.val == y))
                    return false; // same parent
                if(c.val == x)
                    xfound = true;
                if(c.val == y)
                    yfound = true;
                if(c.left != null)
                    q.add(c.left);
                if(c.right != null)
                    q.add(c.right);
            }
            // finally check whether they were found
            if(xfound && yfound) // both found in this level
                return true;
            if(xfound || yfound) // only one found in this level
                return false;
        }

        return false;
    }
}