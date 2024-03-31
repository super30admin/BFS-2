// Time Complexity : O(n) where 'n' is the number of nodes of the tree.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/binary-tree-right-side-view/
// Any problem you faced while coding this : No
// In this we have used BFS Approach

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
        if(root==null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
            TreeNode curr = queue.poll();
            if(i==size-1){
                result.add(curr.val);
            }
            if(curr.left!=null){
                 queue.add(curr.left);
            }
            if(curr.right!=null){
                 queue.add(curr.right);
            }
         }
        }
        return result;
    }
}
