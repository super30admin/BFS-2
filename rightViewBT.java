// Time Complexity : O(n)
// Space Complexity : O(n) -> can go upto O(n/2) in worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class Solution {
    List<Integer> rightView;
    public List<Integer> rightSideView(TreeNode root) {
        rightView = new ArrayList();
        
        if (root == null) {
            return rightView;
        }
       
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        int size = 0;
        TreeNode curr = new TreeNode();
        while(!q.isEmpty()) {
            size = q.size();
            
            for (int i = 0; i < size; i++) {
                curr  = q.poll();
                
                if (curr.left != null) {
                    q.add(curr.left);
                }
                
                if (curr.right != null) {
                    q.add(curr.right);
                }
                
            }
            rightView.add(curr.val);
        }
       return rightView;
    }
}