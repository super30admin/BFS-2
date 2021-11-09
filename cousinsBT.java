// Time Complexity : O(n)
// Space Complexity : O(n) -> can go upto O(n/2) in worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = 0;
        
        while (!q.isEmpty()) {
            boolean xfound = false;
            boolean yfound = false;
            
            size = q.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y) {
                        return false;
                    }
                    if (curr.left.val == y && curr.right.val == x) {
                        return false;
                    }
                }
                
                if (curr.val == x) {
                    xfound = true;
                }
                
                if (curr.val == y) {
                    yfound = true;
                }
                
                //next level
                if (curr.left != null) {
                    q.add(curr.left);
                }
                
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (xfound && yfound) {
                return true;
            } 
        }
        return false;  
    }
}