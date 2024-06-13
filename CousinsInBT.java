import java.util.LinkedList;
import java.util.Queue;

/***
 * Approach - Using BFS
 * TC - O(n), SC - O(n)
 */

class CousinsInBT {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;

        boolean x_found =false, y_found =false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i =0; i < size; i++) {
                TreeNode curr = q.poll();

                if(curr.val == x)
                    x_found = true;

                if(curr.val == y)
                    y_found = true;

                //If both x and y belong to same parent, then return false
                if(curr.left != null && curr.right != null) {
                    if((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x))
                        return false;
                }

                if(curr.left != null)
                    q.add(curr.left);

                if(curr.right != null)
                    q.add(curr.right);

                //If both x and y are found at the same depth, then return true
                if(x_found && y_found)
                    return true;
            }

            x_found = false;
            y_found = false;
        }

        return false;
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
}
