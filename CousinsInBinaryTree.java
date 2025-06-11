// TC: O(n)
// SC: O(n)
// Approach: See if both the elements are at same level, and then check if they 
// both have different parent
// one of the ways to keep track of parent is using hashmap but size would be O(n)
// 1:1 mapping - other way is to keep track of parent is to maintain parallel queue - O(n), O(n)

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public boolean isCousins(TreeNode root, int x, int y) {
    Queue<TreeNode> q = new LinkedList<>();
    Queue<TreeNode> pq = new LinkedList<>();

    q.add(root);
    pq.add(null);

    while (!q.isEmpty()) {
      int size = q.size();
      boolean xFound = false;
      boolean yFound = false;
      TreeNode xParent = null;
      TreeNode yParent = null;

      for (int i = 0; i < size; i++) {
        TreeNode curr = q.poll();
        TreeNode parentCurr = pq.poll();

        if (curr.val == x) {
          xFound = true;
          xParent = parentCurr;
        }
        if (curr.val == y) {
          yFound = true;
          yParent = parentCurr;
        }

        if (curr.left != null) {
          q.add(curr.left);
          pq.add(curr);
        }

        if (curr.right != null) {
          q.add(curr.right);
          pq.add(curr);
        }
      }
      if (xFound && yFound) {
        // both nodes are at same level
        return xParent != yParent;
      }
      if (xFound || yFound)
        return false;
    }
    return false;
  }
}
