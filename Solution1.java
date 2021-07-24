// Time complexity: O(N), where N is the number of ndoes in tree. 
// Space complexity: O(d), where d is the maximum depth of the tree. 

import java.util.*;

class Solution1 {
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

    List<Integer> list; 
    
    public void helper(TreeNode root, int level) {
        // base case
        if (root == null)
            return;
        // add right node val
        if (list.size() == level) {
            list.add(root.val);
        }
        helper(root.right, level + 1);
        helper(root.left, level+1);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<>();
        if(root == null) return list;
        helper(root, 0); 
        return list;
    }
}