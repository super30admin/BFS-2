// Time Complexity : O(n)
// Space Complexity : O(n) - itrartive
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

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
        if(root == null){
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();
        Boolean xFound = false;
        Boolean yFound = false;
        
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i< size; i++){
                TreeNode node = q.poll();
                if(node.val == x){
                    xFound = true;
                }
                if(node.val == y){
                    yFound = true;
                }

                if(node.left != null && node.right != null){
                    if(node.left.val == x && node.right.val == y){
                        return false;
                    }
                    if(node.left.val == y && node.right.val == x){
                        return false;
                    }
                }

                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            if(xFound && yFound){
                return true; 
            }
            if(xFound || yFound){
                return false;
            }

        }
        return false; 
    }
}