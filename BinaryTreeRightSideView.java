// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


import java.util.*;
  //Definition for a binary tree node.
  class TreeNode {
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
 
class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ll = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return ll;
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i =0;i<size;i++){
                TreeNode node = q.poll();
                if (i == size-1 ) ll.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null)q.add(node.right);
            }
        } 
        return ll;
    }
}