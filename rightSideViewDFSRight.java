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
// Time Complexity: We are traversing all the nodes providing O(n) time complexity
// Space Complexity: No additional Datastructure used, O(1)
// Did you complete it on leetcode: Yes
// Any problems faced: providing level++ gives wrong answer while level+1 works fine

// Write your approach here
// Idea here is to recurse through right subtree and and maintain level
// we check if the size of resulting list is equal to the level we are on
// if that is the case, it means there is not element currently present for that level.
// We add the root value to list and continue right recursion.
// if no right node present we recurse to left to find rightmost element of next level
// untill all levels are traversed and recursion has stopped.
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) return result;
        helper(root, 0);
        return result;
    }
    
    public void helper(TreeNode root, int level) {
        if(root==null) return;
        if(result.size()==level) {
            result.add(root.val);
        }
        
        helper(root.right, level+1);
        helper(root.left, level+1);
        
    }
}