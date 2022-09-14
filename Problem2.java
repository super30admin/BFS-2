// ## Problem 2

// Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)


 // Definition for a binary tree node.
  public class Problem2 {
      int val;
      Problem2 left;
      Problem2 right;
     Problem2() {}
      Problem2(int val) { this.val = val; }
     Problem2(int val, Problem2 left, Problem2 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

// dfs solution

// time: O(n)
// space: O(h)
class Solution {
    Problem2 xparent;
    Problem2 yparent;
    int xdepth;
    int ydepth;
    public boolean isCousins(Problem2 root, int x, int y) {
        if (root == null) return false;
        dfs(root, x, y,0,null);
        return xparent != yparent && xdepth == ydepth;
    }
    
    private void dfs(Problem2 root, int x, int y, int depth, Problem2 parent) {
        // base case
        if (root == null) return;
        
        // logic
        if (root.val == x) {
            xparent = parent;
            xdepth = depth;
        }
        
        if (root.val == y) {
            yparent = parent;
            ydepth = depth;
        }
        dfs(root.left, x, y, depth+1, root);
        dfs (root.right, x, y, depth+1, root);
    }
}