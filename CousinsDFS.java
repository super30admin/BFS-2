
// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) where n is the number of nodes in the tree stack space in case of skewed tree
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
//Maintain two global variables for parent and level of x and y. Do a depth first traversal and update the parent and level of x and y when we find them. 
// After the traversal is done check if the level of x and y are the same and if the parent of x and y are different.
//  If both conditions are true then x and y are cousins and we will return true. Otherwise we  will return false.
// We will do a depth first traversal and keep track of the level of the current node and the parent of the current node.
// We will check if the current node is equal to x or y and if it is we will store the level and the parent of the current node.
// After the traversal is done we will check if the level of x and y are the same and if the parent of x and y are different.
//  If both conditions are true then x and y are cousins and we will return true. Otherwise we  will return false.

// Your code here along with comments explaining your approach
// Definition for a binary tree node.
  public class CousinsDFS {
      int val;
      CousinsDFS left;
      CousinsDFS right;
 
     CousinsDFS() {}
 
      CousinsDFS(int val) {
          this.val = val;
      }
 
      CousinsDFS(int val, CousinsDFS left, CousinsDFS right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
 }
 

class Solution {

    CousinsDFS x_parent, y_parent;

    int x_level, y_level;

    public boolean isCousins(CousinsDFS root, int x, int y) {

        helper(root, x, y, null, 0);

        if ((x_level == y_level) && x_parent != y_parent) {
            return true;
        }

        return false;
    }

    public void helper(CousinsDFS root, int x, int y, CousinsDFS parent, int level) {

        if (root == null) {
            return;
        }

        helper(root.left, x, y, root, level + 1);

        if (root.val == x) {
            x_level = level;
            x_parent = parent;
        }

        if (root.val == y) {
            y_level = level;
            y_parent = parent;
        }

        helper(root.right, x, y, root, level + 1);
    }
}