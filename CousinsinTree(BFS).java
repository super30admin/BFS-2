//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)return false;
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()){
            boolean x_val = false;
            boolean y_val = false;         
            int size = q.size();
            for(int i = 0; i < size ; i++ ){
                TreeNode curr = q.poll();
                
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y)return false;
                    if(curr.right.val == x && curr.left.val == y)return false;
                }
                if(curr.val == x)x_val = true;
                if(curr.val == y)y_val = true;
                
                
                if(curr.left != null)q.add(curr.left);
                if(curr.right != null)q.add(curr.right);
                
            }                
            if(x_val && y_val) return true;
            if(x_val || y_val) return false;
        }
        return false;
        
    }
}