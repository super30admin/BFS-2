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
// Time Complexity : O(n) => As we iterate over the n nodes
// Space Complexity : O(n) => As we are storing the nodes in the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach : Using BFS(Level Order Traversal). Take queue and add the root
node. Run a while loop to check if queue is not empty and use size variable
to hold size of the queue. Then using for loop start iterating and store in answer if it is the rightmost node by checking if i==size-1. Then add valid left and right nodes to the
queue.
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> result = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();

            for(int i =0; i<size; i++){
                TreeNode curr = q.poll();

                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }

                //To check if it is the rightmoost node
                if(i == size-1){
                    result.add(curr.val);
                }
            }
        }

        return result;
    }
}