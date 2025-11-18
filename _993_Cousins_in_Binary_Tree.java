/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(h)

//Successfully submitted in LeetCode

//We use Depth first search and store heights and parent nodes of x and y as global variables. So we start by checking if we find x or y, if yes store their height and parent node, later we check if parentX and parentY are not null and not same, then we check their heights if the heights are equal we return true, else move on with recursion.

/**** Method 2 ****/
//Time Complexity: O(n)
//Space Complexity: O(h)

//Successfully submitted in LeetCode

//We use Depth First Search, with boolean values to store foundX, foundY,then use a queue to store all the TreeNodes, start by adding the root to queue, later while queue not empty get the size, and run loop of size iterations and remove each node from queue, if it has left or right or both add them to queue, before this make sure when both left and right not null and both of them are not equal to X and Y later check if node.val is equal to X or Y, after this loop we check if we found both X and Y then return true else if we found any then return false.

import java.util.LinkedList;
import java.util.Queue;

public class _993_Cousins_in_Binary_Tree {

  /**** Method 1 ****/
  int heightX;
  int heightY;
  TreeNode parentX;
  TreeNode parentY;

  public boolean isCousins(TreeNode root, int x, int y) {
    if (root == null) return false;

    return helper(root, null, 0, x, y);
  }

  private boolean helper(
    TreeNode root,
    TreeNode parent,
    int height,
    int x,
    int y
  ) {
    if (root == null) return false;
    if (root.val == x) {
      heightX = height;
      parentX = parent;
    }

    if (root.val == y) {
      heightY = height;
      parentY = parent;
    }

    if (parentX != null && parentY != null && parentX != parentY) {
      if (heightX == heightY) {
        return true;
      }
    }

    return (
      helper(root.right, root, height + 1, x, y) ||
      helper(root.left, root, height + 1, x, y)
    );
  }

  /**** Method 2 ****/
  public boolean isCousins1(TreeNode root, int x, int y) {
    if (root == null) return false;

    Queue<TreeNode> que = new LinkedList<>();
    que.add(root);
    Boolean foundX = false;
    Boolean foundY = false;

    while (!que.isEmpty()) {
      int size = que.size();

      for (int i = 0; i < size; i++) {
        TreeNode node = que.poll();

        if (node.left != null && node.right != null) {
          if (node.left.val == x && node.right.val == y) return false;
          if (node.right.val == x && node.left.val == y) return false;
        }

        if (node.val == x) {
          foundX = true;
        }

        if (node.val == y) {
          foundY = true;
        }

        if (node.left != null) {
          que.add(node.left);
        }

        if (node.right != null) {
          que.add(node.right);
        }
      }
      if (foundX && foundY) return true;
      if (foundX || foundY) return false;
    }

    return false;
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
