// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean xfound = false;
            boolean yfound = false;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                if(node.right != null && node.left != null)
                {
                    if(node.right.val == x && node.left.val == y){
                        return false;
                    }
                    if(node.right.val == y && node.left.val == x){
                        return false;
                    }
                }
                
                if(node.val == x){
                    xfound = true;
                }
                
                if(node.val == y){
                    yfound = true;
                }
                
                if(node.left != null){   
                    queue.add(node.left);
                }
                
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            
    
            if(xfound && yfound){
                return true;
            }            
     }
     return false;
    }
}