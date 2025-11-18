/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(height of the tree)

//Successfully submitted in LeetCode

//Use to queue to store all the TreeNodes, start by adding the root to queue, later while queue not empty get the size, and run loop of size iterations and remove each node from queue, if it has left or right or both add them to queue and then check if it the last node by using the size if yes we can add to ans list. return ans list at the end.

/**** Method 2 ****/
//Time Complexity: O(n)
//Space Complexity: O(h)

//Successfully submitted in LeetCode

//We do Depth first of search with a twist i.e rather than moving left we move right, we maintain a list and height of the tree at each node, if the list size is equal to height, it means we don't have entry for that level in the list, so we add to list, as we are moving to right only the rightmost values will be added to list. At the end return the list.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199_Binary_Tree_Right_Side_View {

  /**** Method 1 ****/
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) return new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    Queue<TreeNode> que = new LinkedList<>();

    que.add(root);

    while (!que.isEmpty()) {
      int size = que.size();

      for (int i = 0; i < size; i++) {
        TreeNode node = que.poll();
        if (node.left != null) {
          que.add(node.left);
        }
        if (node.right != null) {
          que.add(node.right);
        }
        if (i == size - 1) {
          list.add(node.val);
        }
      }
    }

    return list;
  }

  /**** Method 2 ****/
  public List<Integer> rightSideView1(TreeNode root) {
    if (root == null) return new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    helper(root, list, 0);

    return list;
  }

  private void helper(TreeNode root, List<Integer> list, int height) {
    if (root == null) {
      return;
    }

    if (list.size() == height) {
      list.add(root.val);
    }

    helper(root.right, list, height + 1);
    helper(root.left, list, height + 1);
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
