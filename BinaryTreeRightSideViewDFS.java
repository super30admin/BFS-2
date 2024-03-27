// Time Complexity : O(n) - where n is the number of nodes //While loop
// Space Complexity : O(h) - where h is the height of nodes the BST (Recursive Stack Space)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach:
/*
 * During Traversal - Keep adding Nodes at level position every single time
 * Leverage Result ArrayList size; if it first time at that level add node
 * Proceed level by level and replace node to result list
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
        List<Integer> result = new ArrayList<Integer>();
        dfs(root, 0, result); //TreeNode, level, result - pass by reference
        return result;
    }

    //dfs with left, root, right.
    //We have to keep replacing values until recursion unfolds.

    private void dfs(TreeNode root, int level, List<Integer> result){
        //base
        if(root == null) return; //void based recursion

        //logic and recusive calls

        int size = result.size();
        if(level == size ){
            result.add(level, root.val);
        }else{
            result.set(level, root.val); // replace value from right element from previous tree iteration
        }

        dfs(root.left, level+1, result); //First left most to the depth and then right 
        dfs(root.right, level+1, result);

    }
}