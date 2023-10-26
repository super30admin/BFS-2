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
 /* Time Complexity : O(n) 
 *  n - length of the tree */
/* Space Complexity : O(n) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//BSF solution

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> pq = new LinkedList<>();
        q.add(root);
        pq.add(null);
        while(!q.isEmpty()){
            int size = q.size();
            boolean found_x = false;
            boolean found_y = false;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.val == x){
                    found_x = true;
                }
                if(curr.val == y){
                    found_y = true;
                }
				
				//If curr root has both right and left child and if they are x and y then return false
                if(curr.left != null && curr.right != null){
                    if((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)) return false;
                }

                if(curr.left != null){
                    q.add(curr.left);        
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            if(found_x && found_y){
                return true;
            }
            if(found_x  || found_y) return false;
        }
        return false;
    }
}