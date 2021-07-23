// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || root.val == x || root.val == y)
            return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        boolean xFound = false, yFound = false;
        
        while(!queue.isEmpty()){
            int sz = queue.size();
            
            for(int i = 0; i < sz; i++){
                TreeNode curr = queue.poll();
                
                if(curr.val == x) xFound = true;
                if(curr.val == y) yFound = true;
                
                //sibling check
                if(curr.left != null && curr.right != null){
                    int val1 = curr.left.val;
                    int val2 = curr.right.val;
                    
                    if((x == val1 && y == val2) || (y == val1 && x == val2)){
                        return false;
                    }
                }
                
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
                
            }
            
            if(xFound && yFound) return true;
            if(xFound || yFound) return false;
        }
        
        return false;
    }
}







