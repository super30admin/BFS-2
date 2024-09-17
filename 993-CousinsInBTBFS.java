/**LC-993 Easy
 * Time Complexity : O(N) 
 * Space Complexity : O(N/2) = O(N) (Queue space)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm:
 1. If root == null return result
 2. Used size variable since we need to compare nodes in each level
 3. If x or y is equal to the current node, update the boolean value x_found/y_found
 4. if x and y are child of the same parent return false
 5. if x and y are not found return false;

 */
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
        
         
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                
                if(curr.val == x)
                    x_found = true;
                if(curr.val == y)
                    y_found = true;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                if(curr.right != null && curr.left != null){
                    if((x == curr.left.val && y == curr.right.val) || (y == curr.left.val && x== curr.right.val)) return false;
                } 
            }
            if(x_found && y_found) return true;
            
        }
        return false;
       
    }
}