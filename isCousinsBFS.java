package BFS2;

/* Time complexity : o(n) 
space complexity: o(n) 
Did this code run successfully in leetcode : yes
problems faces : no
*/
import java.util.LinkedList;
import java.util.Queue;

public class isCousinsBFS {
	  public class TreeNode {
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
	
	public boolean isCousinsBFS(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean x_found = false;
            boolean y_found = false;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.val == x) x_found = true;
                if (temp.val == y) y_found = true;

                if (temp.left != null && temp.right != null) {
                    if (temp.left.val == x && temp.right.val == y) return false;
                    if (temp.left.val == y && temp.right.val == x) return false;
                }
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            if (x_found && y_found) return true;
            // if(x_found || y_found) return true;
        }
        return false;
    }
}
