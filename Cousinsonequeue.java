// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) where n is the number of nodes in the tree queue space in case of skewed tree
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// We will do a level order traversal and keep track of the parent of each node in the queue.
// We will check if the current node is equal to x or y and if it is we will check if the parent of the current node is the same as the parent of the other node.
// If the parents are the same then x and y are siblings and we will return false.
// If the parents are different then we will check if we have found both x and y in the same level and if we have then we will return true. 
// Otherwise we will return false.

// Your code here along with comments explaining your approach
import java.util.*;


 // Definition for a binary tree node.
  public class Cousinsonequeue {
      int val;
      Cousinsonequeue left;
      Cousinsonequeue right;
 
      Cousinsonequeue() {}
 
      Cousinsonequeue(int val) {
          this.val = val;
      }
 
      Cousinsonequeue(int val, Cousinsonequeue left, Cousinsonequeue right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 

class Solution {

    public boolean isCousins(Cousinsonequeue root, int x, int y) {

        if (root == null) {
            return false;
        }

        Queue<Cousinsonequeue> que = new LinkedList<>();

        que.offer(root);

        while (!que.isEmpty()) {

            int count = que.size();

            boolean x_found = false;
            boolean y_found = false;

            for (int i = 0; i < count; i++) {

                Cousinsonequeue curr = que.poll();

                if (curr.left != null && curr.right != null) {

                    if (curr.left.val == x && curr.right.val == y) {
                        return false;
                    }

                    if (curr.left.val == y && curr.right.val == x) {
                        return false;
                    }
                }

                if (curr.val == x) {
                    x_found = true;
                }

                if (curr.val == y) {
                    y_found = true;
                }

                if (curr.left != null) {
                    que.offer(curr.left);
                }

                if (curr.right != null) {
                    que.offer(curr.right);
                }
            }

            if (x_found && y_found) {
                return true;
            }

            if (x_found || y_found) {
                return false;
            }
        }

        return false;
    }
}