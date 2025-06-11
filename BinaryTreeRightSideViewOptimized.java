// TC: O(n)
// SC: O(h) resursive stack space, no auxiliary space
// Approach : Recursion, Take every level in additional list and take last element
// of each list
// One of the ways to do DFS where you do right recursive call first and then left recursive call
// Check if the result size is equal to level, if it is that means that level element is already there.
// if size is smaller than level that means that level is not yet explored so add that element in result
// Or if you do left recursive calls - keep updating/overwriting the values till you get last element of that level

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideViewOptimized {

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
    dfs(root, 0, result);
    return result;

  }

  private void dfs(TreeNode root, int level, List<Integer> result) {
    // base
    if (root == null)
      return;
    // logic
    if (result.size() == level) {
      result.add(root.val);
    }

    dfs(root.right, level + 1, result);
    dfs(root.left, level + 1, result);
  }
}