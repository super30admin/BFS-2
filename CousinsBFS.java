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
    
   /**
    * 1. Use BFS
    * 2. In a given level check if both the nodes are found are not
    *            2.1 If both not found go to other level
    *            2.2 If one found and other not found return false.
    *            2.3 If both found check if they are having same parent, if not return true
    *
    *     While processing current node itself we are checking if x & y are siblings.
    *     Hence avoiding to store parent of each node.
    *
    * Time complexity: Visit each node once O(no.of nodes in tree)
    * Space complexity: At any given time the max elements that a queue will hold is at the leaf level.
    *                        O(max no of nodes at last level or leaf level) = O(n/2) == O(n)
    *
    */
    
    public boolean isCousins(TreeNode root, int x, int y) {
    
        if(root == null) return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            boolean xFound = false;
            boolean yFound = false;
            for(int i = 0; i < size; i++) {
               
                TreeNode curr = q.poll();
 
                // Same parent check
                if(curr.left != null && curr.right != null) {
                    if((curr.left.val == x && curr.right.val == y) ||
                   (curr.left.val == y && curr.right.val == x)) 
                    return false;
                }
                
                // Setting x & y found 
                if(curr.val == x) xFound = true; 
                if(curr.val == y) yFound = true;
                
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);   
            }
            
            // At the end of traversing each level, check if x & y found.
            if(xFound && yFound) return true;
            if(xFound || yFound) return false;
            
        }
        
        return false;
        
    }
}
