// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> output = new ArrayList<>();
    //base case
    if (root == null) return output;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    //we take a temp variable and initialize it to -1
    int temp = -1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode current = queue.poll();
        //during every iteration, temp will be overwritten. So, the last value in temp
        //before exiting the for loop will be the value of the right child
        temp = current.val;
        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);
      }
      output.add(temp);
    }
    return output;
  }
}
