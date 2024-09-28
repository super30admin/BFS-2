/**
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
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
        
        if(root == null)
            return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int qsize = queue.size();
            boolean is_x_found = false;
            boolean is_y_found = false;
            
            for(int i=0;i<qsize;i++)
            {
                TreeNode curr = queue.poll();
                if(curr.val ==x) is_x_found = true;
                if(curr.val == y) is_y_found = true;
                
                if(curr.left !=null &&  curr.right!=null)
                {
                    if((curr.left.val == x && curr.right.val == y) || (curr.left.val==y && curr.right.val ==x))
                        return false;                        
                    
                }
                
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
            
            if(is_x_found && is_y_found) return true;            
        }
        return false;        
    }
}