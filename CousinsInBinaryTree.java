// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        //null
        if(root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            boolean xFound = false;
            boolean yFound = false;
            for(int i =0; i<size; i++) {
                TreeNode curr = q.poll();
                if(curr.val == x) {
                    xFound = true;
                }

                if(curr.val == y) {
                    yFound = true;
                }

                //if children are x and y
                if(curr.left != null && curr.right != null) {
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }

                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            if(xFound && yFound) return true;
            if(xFound || yFound) return false;
        }
        return true;
    }
}
