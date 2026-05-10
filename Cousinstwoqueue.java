// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity :   O(n) where n is the number of nodes in the tree queue space in case of skewed tree
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// We will do a level order traversal and keep track of the parent of each node in the queue.
// We will check if the current node is equal to x or y and if it is we will check if the parent of the current node is the same as the parent of the other node.
// If the parents are the same then x and y are siblings and we will return false.
// If the parents are different then we will check if we have found both x and y in the same level and if we have then we will return true. 
// Otherwise we will return false.
// Your code here along with comments explaining your approach
import java.util.*;


 //Definition for a binary tree node.
 public class Cousinstwoqueue {
      int val;
      Cousinstwoqueue left;
      Cousinstwoqueue right;
 
     Cousinstwoqueue() {}
 
      Cousinstwoqueue(int val) {
          this.val = val;
      }
 
     Cousinstwoqueue(int val, Cousinstwoqueue left, Cousinstwoqueue right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
 

class Solution {

    public boolean isCousins(Cousinstwoqueue root, int x, int y) {

        if (root == null) {
            return false;
        }

        Queue<Cousinstwoqueue> que = new LinkedList<>();
        Queue<Cousinstwoqueue> quep = new LinkedList<>();

        que.offer(root);
        quep.offer(null);

        while (!que.isEmpty()) {

            int count = que.size();

            boolean x_found = false;
            boolean y_found = false;

            Cousinstwoqueue x_parent = null;
            Cousinstwoqueue y_parent = null;

            for (int i = 0; i < count; i++) {

                Cousinstwoqueue curr = que.poll();
                Cousinstwoqueue parent = quep.poll();

                if (curr.val == x) {
                    x_found = true;
                    x_parent = parent;
                }

                if (curr.val == y) {
                    y_found = true;
                    y_parent = parent;
                }

                if (curr.left != null) {
                    que.offer(curr.left);
                    quep.offer(curr);
                }

                if (curr.right != null) {
                    que.offer(curr.right);
                    quep.offer(curr);
                }
            }

            if ((x_found && y_found) && x_parent != y_parent) {
                return true;
            }

            if (x_found || y_found) {
                return false;
            }
        }

        return false;
    }
}