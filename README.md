# BFS-2

## Problem 1

Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

<!-- Time Complexity = O(N)
Space Complexity = O(N) -->

/\*\*

- Definition for a binary tree node.
- public class TreeNode {
-     int val;
-     TreeNode left;
-     TreeNode right;
-     TreeNode() {}
-     TreeNode(int val) { this.val = val; }
-     TreeNode(int val, TreeNode left, TreeNode right) {
-         this.val = val;
-         this.left = left;
-         this.right = right;
-     }
- }
  \*/
  class Solution {
  public List<Integer> rightSideView(TreeNode root) {
  List<Integer> result = new ArrayList<>();
  if(root == null) {
  return result;
  }
  Queue<TreeNode> queue = new LinkedList<>();
  queue.add(root);
  while(!queue.isEmpty()) {
  int sz = queue.size();
  TreeNode current = root;
  for(int i = 0; i < sz; i++) {
  current = queue.poll();
  if(current.left != null) {
  queue.add(current.left);
  }
  if(current.right != null) {
  queue.add(current.right);
  }
  }
  result.add(current.val);
  }
  return result;
  }
  }

## Problem 2

Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)

<!-- Time Complexity = O(N)
Space Complexity = O(N) -->

/\*\*

- Definition for a binary tree node.
- public class TreeNode {
-     int val;
-     TreeNode left;
-     TreeNode right;
-     TreeNode() {}
-     TreeNode(int val) { this.val = val; }
-     TreeNode(int val, TreeNode left, TreeNode right) {
-         this.val = val;
-         this.left = left;
-         this.right = right;
-     }
- }
  \*/
  // class Solution {
  // int level1;
  // int level2;
  // TreeNode prev1;
  // TreeNode prev2;
  // public boolean isCousins(TreeNode root, int x, int y) {
  // if(root == null) {
  // return false;
  // }
  // level1 = -1;
  // level2 = -1;
  // prev1 = null;
  // prev2 = null;
  // helper(root, 0, null, x, y);

// return (level1 == level2 && prev1.val != prev2.val);
// }

// private void helper(TreeNode root, int level,TreeNode prev, int x, int y) {
// if(root == null) {
// return;
// }

// if(root.val == x && prev != null) {
// prev1 = prev;
// }
// if(root.val == y && prev != null) {
// prev2 = prev;
// }

// if(root.val == x) {
// level1 = level;
// }
// if(root.val == y) {
// level2 = level;
// }

// helper(root.left,level+1,root, x,y);
// helper(root.right,level+1,root, x,y);
// }
// }

class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || root.val == x || root.val == y) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean xFound = false;
        boolean yFound = false;
        while(!queue.isEmpty()) {
            int sz = queue.size();
            for(int i = 0; i < sz;i++) {
                TreeNode current = queue.poll();

                if(current.val == x) {
                    xFound = true;
                }
                if(current.val == y) {
                    yFound = true;
                }
                if(current.left != null && current.right != null) {
                    int val1 = current.left.val;
                    int val2 = current.right.val;
                    if((x == val1 && y == val2) || (y == val1 && x == val2)) {
                        return false;
                    }
                }
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            if(xFound == true && yFound == true) {
                return true;
            }
            if(xFound == true || yFound == true) {
                return false;
            }
        }
        return false;
    }

}
