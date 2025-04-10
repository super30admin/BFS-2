//Time Complexity: O(n) where n is the number of nodes in the binary tree
//Space Complexity: O(n) for the queue used in the breadth-first search



public class CousinsInBinaryTree {
 // Definition for a binary tree node.
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
 
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean foundx = false, foundy = false;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                //check if they are siblings
                if (current.left != null && current.right != null) {
                    if (current.left.val == x && current.right.val == y)
                        return false;
                    if (current.left.val == y && current.right.val == x)
                        return false;
                }

                if (current.val == x) {
                    foundx = true;
                }
                if (current.val == y) {
                    foundy = true;
                }

                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
            }
            if (foundx && foundy) {
                return true;
            }

            if (foundx || foundy) {
                return false;
            }
        }
        return false;
    }
}
    
}
