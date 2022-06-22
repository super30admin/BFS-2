// https://leetcode.com/problems/cousins-in-binary-tree/submissions/

// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            boolean x_flag = false; boolean y_flag = false;
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if(curr.val == x) x_flag = true;
                if(curr.val == y) y_flag = true;
                
                if(curr.left != null && curr.right != null) {
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
                 
            if(x_flag && y_flag) return true;
            if(x_flag || y_flag) return false;
        }
        
    return false;
    }
}