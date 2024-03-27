
// Time Complexity : O(n) - where n is the number of nodes //While loop
// Space Complexity : O(n) - where n is the number of nodes the BST (Queue)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach:
/*
 * Keep adding node in the queue
 * Maintain level
 * Proceed level by level and add node to result if it is the last node in that level i= size-1
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result  = new ArrayList<>(); //output result
        //approach with Level Order Traversal (BFS)
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return result;
        
        q.add(root);
        int size = 0;

        //processing of level
        while(!q.isEmpty()){
            size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();

                if(i == size - 1){
                    result.add(curr.val);
                }

                if(curr.left != null){
                    q.add(curr.left);
                }
                
                if(curr.right != null){
                    q.add(curr.right);
                }

            }
        }
        return result;
    }
}