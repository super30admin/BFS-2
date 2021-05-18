// Time complexity - O(n)
// Space complexity - O(n/2) = O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        
        
        if(root == null){
            
            return result;
        }
       //result.add(root.val);
        q1.add(root);
        
        while(!q1.isEmpty()){
            
            int queueSize = q1.size();
            
            for(int i = 0; i < queueSize; i ++){
                
                TreeNode temp = q1.poll();
                
                if(i == 0){
                    
                    result.add(temp.val);
                }
                
                if(temp.right != null){
                    q1.add(temp.right);
                }
                
                if(temp.left != null){
                    
                    q1.add(temp.left);
                }
            }
        }
        return result;
    }
}