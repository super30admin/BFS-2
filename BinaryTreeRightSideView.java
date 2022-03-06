// TC : O(n) 
// SC: O(h)

// Approach: Iterate throught the tree using Preorder traversal with node and 
// level and maintain a list. If we can see that list's size is equal to our 
// current level, we add a new the current node's value to our list. 
// For every level, we keep updating the value in the list with our latest node.
// This way, we always store the right node for every level.

// LC- 199. Binary Tree Right Side View

import java.util.*;

class TreeNode {
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

public class BinaryTreeRightSideView {

  ArrayList<Integer> result = new ArrayList<>();

  public List<Integer> rightSideView(TreeNode root) {
    result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    helper(root, 0);
    return result;
  }

  public void helper(TreeNode node, int level) {
    if (node == null) {
      return;
    }

    // NLR
    if (result.size() == level) {
      result.add(node.val);
    } else {
      result.set(level, node.val);
    }

    helper(node.left, level + 1);
    helper(node.right, level + 1);
  }
}
