// Time Complexity : O(n) 
// Space Complexity : O(n) highesh width of the binary tree which can be n/2
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


import java.util.*;
//   Definition for a binary tree node.
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
 
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new java.util.LinkedList<>();
        
        queue.add(root);
        int size = 1;
        int count = 0;
        while(! queue.isEmpty()){
            TreeNode curr = queue.poll();
            count++;
            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
            if(count == size){
                result.add(curr.val);
                count = 0;
                size = queue.size();
            }
            
        }
        return result;
        
    }
}