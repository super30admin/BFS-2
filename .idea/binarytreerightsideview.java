// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english


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
        Queue<TreeNode> queue = new LinkedList<>(); //Creates a queue
        List<Integer> result = new ArrayList<>(); //Creates a result list
        queue.add(root); //Add root to the queue
        while(!queue.isEmpty()){
            if(root == null) return result; //If root is null
            int size = queue.size(); //Calculate the size
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll(); //Remove the curr elem from queue
                System.out.println(curr);
                if(i == size - 1){ //Adding the last elem from the queue in the result list for each level
                    result.add(curr.val);
                }
                if(curr.left != null){
                    queue.add(curr.left); //Adding the child nodes
                }
                if(curr.right != null){
                    queue.add(curr.right); //Adding the child nodes
                }
            }
        }
        return result;
    }
}