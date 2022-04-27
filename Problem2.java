// Time Complexity : O(n) where n is number of nodes
// Space Complexity : O(n) where n is number of nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

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

    class Pair {

        private TreeNode curr;
        private int parent;
        
        Pair(TreeNode curr, int parent) {
            this.curr = curr;
            this.parent = parent;
        }
        
        public TreeNode getCurr() {
            return curr;
        }
        
        public int getParent() {
            return parent;
        }
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
          
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            
            boolean foundX = false;
            boolean foundY = false;
            
            int parentX = 0;
            int parentY = 0;
            
            for (int i = 0; i < size; i++) {
                
                Pair p = q.remove();
                
                TreeNode curr = p.getCurr();
                
                //process
                if (curr.val == x) {
                    foundX = true;
                    parentX = p.getParent();
                }
                
                if (curr.val == y) {
                    foundY = true;
                    parentY = p.getParent();
                }
                
                // add left
                if (curr.left != null) {
                    q.add(new Pair(curr.left, curr.val));    
                }
                
                // add right
                if (curr.right != null) {
                    q.add(new Pair(curr.right, curr.val));    
                }             
            }
            
            if (foundX && foundY) {
                return parentX != parentY;
            }
            
            // x not found and y not found
            if (foundX || foundY) {
                return false;
            }
        }
        
        return false;
    }
}