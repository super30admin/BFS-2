/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null){
            return false;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            boolean x_found = false;
            boolean y_found = false;
            
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.val == x){
                    x_found = true;
                }    
                
                if(node.val == y){
                    y_found = true;
                }
                
                if(node.left != null && node.right != null){
                    if(node.left.val == x && node.right.val == y || 
                    node.right.val == x && node.left.val == y)
                       return false;    
                }
                
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            
            if(x_found && y_found){
                return true;
            }
            
        }
        
        return false;
        
    }
}