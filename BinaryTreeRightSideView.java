// TC: O(n)
// SC: O(n)
// Approach 1 : Level order traversl using BFS , take last element at every level - O(n), O(n)
// Approach 2 : Recursion, Take every level in additional list and take last element of each list, additional sapce of O(n)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

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

  public List<Integer> rightSideView(TreeNode root) {

    List<Integer> result = new ArrayList<>();
    if (root == null)
      return result;
    Queue<TreeNode> q = new LinkedList<>();

    q.add(root);

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode curr = q.poll();
        if (i == size - 1) {
          result.add(curr.val);
        }
        if (curr.left != null) {
          q.add(curr.left);

        }
        if (curr.right != null) {
          q.add(curr.right);
        }
      }
    }
    return result;
  }
}