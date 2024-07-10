// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// BFS Solution
 /*
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        boolean xFound = false;
        boolean yFound = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i<size; i++) {
                TreeNode current = queue.poll();
                if(current.val == x) xFound = true;
                if(current.val == y) yFound = true;
                if(current.left!=null && current.right!=null) {
                    if(current.left.val == x && current.right.val == y) return false;
                    if(current.right.val == x && current.left.val == y) return false;
                }
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }

            if(xFound && yFound) return true;
            if(xFound || yFound) return false;
        }
        return false;
    }
}*/

class Solution {
  TreeNode xParent, yParent;
  int xLevel, yLevel;
  int x,y;
  public boolean isCousins(TreeNode root, int x, int y) {
    this.x = x;
    this.y = y;
    if(root == null) return false;
    dfs(root, 0, null);
    return (xLevel == yLevel) && (xParent != yParent);
  }

  void dfs(TreeNode root, int level, TreeNode parent) {
    if(root == null) return;

    if(root.val == x) {
      xParent = parent;
      xLevel = level;
    }

    if(root.val == y) {
      yParent = parent;
      yLevel = level;
    }

    dfs(root.left, level+1, root);
    dfs(root.right, level+1, root);
  }
}