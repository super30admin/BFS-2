/**
 * Definition for a binary tree node.
//https://leetcode.com/submissions/detail/617863195/ 
//Time: O(n)
//Space: O(n)

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
    
    List<Integer> rightView;
    public List<Integer> rightSideView(TreeNode root) {
        rightView = new ArrayList<>();
        if(root == null) {
            return rightView;
        }
      
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        int size = 0;
        
        while(!q.isEmpty()) {
            size = q.size();
            TreeNode curr = new TreeNode();
            for(int i = 0; i < size; i++) {
                
                curr = q.poll();
                if(curr.left != null) {
                    q.add(curr.left);
                }
                
                 if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            
            rightView.add(curr.val);
        }
        return rightView;
    }
}