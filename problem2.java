import java.util.LinkedList;
import java.util.Queue;

// Time Complexity: O(n)
// Space Complexity: O(n/2)=O(n)
public class problem2 {

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
    public boolean isCousins(TreeNode root, int x, int y) {
          if(root==null){  return true; }
          Queue<TreeNode> queue = new LinkedList<>();
          queue.add(root);
          Queue<TreeNode> parentQ = new LinkedList<>();
          parentQ.add(null);
          TreeNode xParent = null, yParent = null;
          boolean xFound = false, yFound = false;
          while(!queue.isEmpty()){
              int size= queue.size();
              for(int i=0; i<size; i++) {
                  TreeNode curr = queue.poll();
                  TreeNode parent = parentQ.poll();

                  if (curr.val == x) {
                      xFound = true;
                      xParent = parent;
                  }
                  if (curr.val == y) {
                      yFound = true;
                      yParent = parent;
                  }
                  if (curr.left != null) {
                      queue.add(curr.left);
                      parentQ.add(curr);
                  }
                  if (curr.right != null) {
                      queue.add(curr.right);
                      parentQ.add(curr);
                  }
              }
              if (xFound && yFound) {
                  return xParent!=yParent;
              }
              if (xFound || yFound) {
                  return false;
              }
          }
          return true;
    }
}