// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {

  public boolean isCousins(TreeNode root, int x, int y) {
    if (root == null) return false;
    Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
    //adding the node and it's parent
    q.add(new Pair<TreeNode, Integer>(root, -1));

    while (!q.isEmpty()) {
      int size = q.size();
      int parentX = -1, parentY = -1;
      for (int i = 0; i < size; i++) {
        Pair<TreeNode, Integer> front = q.poll();
        //Retrieving the values
        TreeNode node = front.getKey();
        int parent = front.getValue();
        //Update the parents
        if (node.val == x) parentX = parent; else if (node.val == y) parentY =
          parent;
        //Adding the children to the queue
        if (node.left != null) q.add(
          new Pair<TreeNode, Integer>(node.left, node.val)
        );
        if (node.right != null) q.add(
          new Pair<TreeNode, Integer>(node.right, node.val)
        );
      }
      //Verify
      if (
        parentX != -1 && parentY != -1 && parentX != parentY
      ) return true; else if (parentX != -1 || parentY != -1) return false;
    }
    return false;
  }
}
