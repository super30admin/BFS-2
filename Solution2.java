// Time complexity: O(N), where N is the number of ndoes in tree. 
// Space complexity: O(N)

import java.util.*;

public class Solution2 {
    class Solution {
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


    public boolean isCousins(TreeNode root, int x, int y) {
        boolean xFound = false;
        boolean yFound = false; 
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); 
        
        while(!queue.isEmpty()) {
            int size = queue.size(); 
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                // if val is x, set xFound to true
                if (node.val == x) {
                    xFound = true;
                }
                // if val is y, set yFound to true
                else if(node.val == y) {
                    yFound = true;
                }
                if (node.left != null && node.right != null) {
                    // check if the node are siblings
                    if ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }
                // else add it to queue
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            
            // if both values are found at the same level
            if (xFound && yFound)
                return true;
            // if only one value is found 
            if(xFound || yFound) return false;
        }
        
        return false;
    }
}
}
