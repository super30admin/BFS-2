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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new java.util.LinkedList<>();
        HashMap<Integer, Integer> parent = new HashMap<>();
        queue.add(root);
        parent.put(root.val, null);
        int size = 1;
        int height = 1;
        int xh = -1;
        int yh = -1;
        while(! queue.isEmpty()){
            
            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                if(curr.val == x){
                    xh = height;
                }
                else if(curr.val == y){
                    yh = height;
                }

                if(curr.left !=null){
                    queue.add(curr.left);
                    parent.put(curr.left.val, curr.val);
                }
                if(curr.right !=null){
                    queue.add(curr.right);
                    parent.put(curr.right.val, curr.val);
                }
            }
            height++;
            size = queue.size();
            if(xh != -1 && yh != -1) return parent.get(x) != parent.get(y);
            if(xh != - 1 || yh != -1) return false;
        }

        return false;
    }
}