// Time Complexity : O(N)
// Space Complexity : O(N)
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
        
        Deque<TreeNode> queue = new LinkedList();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            int flag = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                
                if(node.right != null && node.left != null){
                    if((node.left.val == x || node.left.val == y) &&
                       (node.right.val == x || node.right.val == y)){
                        return false;
                    }
                }
                if(node.left != null){
                    if(node.left.val == x || node.left.val == y){
                        flag++;
                    }
                    queue.offer(node.left);
                }
                if(node.right != null){
                    if(node.right.val == x || node.right.val == y){
                        flag++;
                    }
                    queue.offer(node.right);
                }
            }//for
            
            if(flag == 2){
                return true;
            }else if(flag == 1){
                return false;
            }
        }
        return false;
    }
}
