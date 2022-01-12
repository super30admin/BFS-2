// Time: O(n)
// Space: O(n)
// https://leetcode.com/submissions/detail/617958322/

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
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
     
            
        int size = 0;
        while(!q.isEmpty()) {
            size = q.size();
             boolean xfound = false;
             boolean yfound = false;
            
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
            
                if(curr.left != null && curr.right != null) {
                
                    if(curr.left.val == x && curr.right.val == y) {

                        return false;
                    }
                    if(curr.right.val == x && curr.left.val == y) {

                        return false;
                    }                
                }
                
                if(curr.val == x) {
                    xfound = true;
                }
                
                if(curr.val == y) {
                    yfound = true;
                }
                
                if(curr.left != null) {
                    q.add(curr.left);
                }
                
                if(curr.right != null) {
                    q.add(curr.right);
                } 
                
            }
            
            if( xfound && yfound ){
                return true;
            }
           
        }
        return false;
    }
}