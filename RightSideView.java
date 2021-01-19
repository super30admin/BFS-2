// Time Complexity : The time complexity is O(n) where n is the number of tree nodes
// Space Complexity : The space complexity if O(l) where l is the maximum number of nodes in a level
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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

        List<Integer> output = new LinkedList<>();

        if(root==null){
            return output;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int size = q.size();

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            size--;

            if(node.left!=null){
                q.offer(node.left);
            }

            if(node.right!=null){
                q.offer(node.right);
            }

            // The right view node would be the last node in the level
            if(size==0){
                output.add(node.val);
                size=q.size();
            }
        }

        return output;

    }
}