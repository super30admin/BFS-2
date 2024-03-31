// Time Complexity : O(n) where 'n' number of nodes in the tree.
// Space Complexity : O(height) where height is the height of the binary tree
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/isomorphic-strings/
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
        if(root==null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean xFound = false;
            boolean yFound = false;
            for(int i=0;i<size;i++){
                TreeNode element = queue.poll();
                if(element.val==x){
                    xFound = true;
                }
                if(element.val==y){
                    yFound = true;
                }
                if(element.left!=null && element.right!=null){
                    if(element.left.val==x && element.right.val==y) return false;
                    if(element.left.val==y && element.right.val==x) return false;
                }
                if(element.left!=null){
                    queue.add(element.left);
                }
                if(element.right!=null){
                    queue.add(element.right);
                }
            }
            if(xFound&&yFound) return true;
             if(xFound||yFound) return false;
        }
        return false;
    }
}
