 /*
Time Complexity : O(n) where n is number of nodes in tree.
Space Complexity :  O(h) where h is size of the queue.

 */

import java.util.*;
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
 

public class Rightview {

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        int temp = 0;
        while(!queue.isEmpty()) {
            
            int size = queue.size(); 
            while(size -- > 0) {
                
                TreeNode curr = queue.poll();
                if(size == temp) {
                    
                    list.add(curr.val);
                }
                
                if(curr.left != null) {
                    
                    queue.add(curr.left);
                }
                
                if(curr.right != null) {
                    
                    queue.add(curr.right);
                }
                
            }
            
            
        }
        
        return list;
    }
}