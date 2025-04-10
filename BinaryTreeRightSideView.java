import java.util.*;
import java.util.LinkedList;

//Time Complexity: O(n) where n is the number of nodes in the binary tree
//Space Complexity: O(n) for the queue used in the breadth-first search

// Perform level-order traversal using a queue to process nodes level by level.
// At each level, add the last node's value to the result list to capture the rightmost view.
// Continue until all levels are processed and return the result.


public class BinaryTreeRightSideView {
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
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                if (i == size - 1) {
                    result.add(curr.val);
                }
            }
        }
        return result;
    }
}    
}