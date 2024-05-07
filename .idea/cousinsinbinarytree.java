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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>(); //Create a queue
        Queue<TreeNode> parentQueue = new LinkedList<>(); //Another queue for keeping track of the parents
        boolean xFound = false;
        boolean yFound = false;
        int xParent = 0;
        int yParent = 0;

        queue.add(root);
        parentQueue.add(null);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll(); //Remove the curr element from the queue
                TreeNode parent = parentQueue.poll(); //Remove the parent of the current elem from the queue
                if(curr.val == x){
                    xFound = true; //If x is found
                    xParent = parent.val; //Set the child and parent
                }
                if(curr.val == y){
                    yFound = true; //If y is found
                    yParent = parent.val; //Set the child and parent
                }
                if(curr.left != null){
                    queue.add(curr.left); //Add the child to the queue
                    parentQueue.add(curr); //Add the parent to the queue
                }
                if(curr.right != null){
                    queue.add(curr.right); //Add the child to the queue
                    parentQueue.add(curr); //Add the parent to the queue
                }
                if(xFound && yFound && xParent != yParent){ //If the parents are not the same then return true
                    return true;
                }
                if(xFound || yFound){ //If only x or y is found then return false
                    return false;
                }
            }
        }
        return false;
    }
}