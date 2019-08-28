// Time Complexity : O(n) - n is equal to number of nodes in Tree (in worst case)
// Space Complexity : O(n) - using extra space - queue 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Saw video and was able to do
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) { 
        if(root == null){
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int count = q.size();
            boolean x_found = false, y_found = false;
            for(int i = 0; i< count; i++){
                TreeNode node = q.poll();
                
                if(node.left != null && node.right!= null){
                    if(node.left.val == x && node.right.val == y){
                        return false;
                    }
                    if(node.right.val == x && node.left.val == y){
                        return false;
                    }
                }
                
                if(node.val == x ) x_found = true;
                else if(node.val == y) y_found = true;
                
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                
            }
            if(x_found && y_found) return true;
            
        }
        
        return false;
    }
}