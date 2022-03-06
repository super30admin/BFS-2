// TC : O(n) 
// SC: O(n)

// Approach: we find the level and parent of x and y by using preorder.
// At every level, we check if we find x or y and update our global 
// variables accordingly. 

// LC- 993. Cousins in Binary Tree

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

public class CousinsInBinaryTree {
  TreeNode xParent, yParent;
  int xLevel, yLevel;
  int x, y;

  public boolean isCousins(TreeNode root, int x, int y) {
    xParent = null;
    yParent = null;
    xLevel = 0;
    yLevel = 0;
    this.x = x;
    this.y = y;

    if (root == null) {
      return false;
    }
    helper(root, null, 0);

    return xParent != yParent && xLevel == yLevel;
  }

  public void helper(TreeNode root, TreeNode parent, int level) {
    if (root == null) {
      return;
    }

    // Preorder
    if (root.val == x) {
      xParent = parent;
      xLevel = level;
    }

    if (root.val == y) {
      yParent = parent;
      yLevel = level;
    }

    helper(root.left, root, level + 1);
    helper(root.right, root, level + 1);
  }
}
