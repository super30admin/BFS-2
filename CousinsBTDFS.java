// Time Complexity : O(n) - where n is the number of nodes //While loop
// Space Complexity : O(h) - where h is the height of recursive stack

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach:
/*
 * Keep traversing till x and y are not being found
 * when you find x or y - store its level and parent
 * If both are at same level and of from different parent then return true
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

 //DFS Approach - Trying with base condition

 class Solution {
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
    boolean flag = false;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, null, x, y , 0); // there is no parent of root. Level is 0 

        if(x_depth == y_depth && x_parent!= y_parent){
            flag = true;
        }
        return flag;
    }

    private void dfs(TreeNode root, TreeNode parent, int x, int y , int level){
        
        //base
        if(root == null) return;
        if(x_parent != null && y_parent!= null) return;
        System.out.println(root.val);

        //logic
        if(root.val == x){
            x_depth = level;
            x_parent = parent;
        }

        if(root.val == y){
            y_depth = level;
            y_parent = parent;
        }

        if(x_parent == null || y_parent == null)
            dfs(root.left, root, x, y, level+1);

        if(x_parent == null || y_parent == null)
            dfs(root.right, root, x, y, level+1);
    }

}